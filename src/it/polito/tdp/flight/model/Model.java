package it.polito.tdp.flight.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graphs;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.traverse.DepthFirstIterator;

import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import it.polito.tdp.flight.db.FlightDAO;

public class Model {
	
	private FlightDAO dao;
	private List<Airline> linee;
	private List<Airport> airports;
	private Map<Integer,Airport> mapAirports;
	private SimpleDirectedWeightedGraph<Airport,DefaultWeightedEdge> graph;

	
	public Model() {
		super();
		dao=new FlightDAO();
		
	}
	
	public List<Airline> getAllLinee(){
		if(this.linee==null)
			linee=dao.getAllAirline();
		
		Collections.sort(linee);
		return linee;
	}
	
	public List<Airport> getAllAirports(){
		if(this.airports==null){
			airports=dao.getAllAirports();
			this.mapAirports=new HashMap<Integer,Airport>();
			for(Airport atemp:airports)
				this.mapAirports.put(atemp.getAirportId(), atemp);
			
		}
		
		return airports;
	}
	
	public void creaGrafo(Airline airline){
		
		graph=new SimpleDirectedWeightedGraph<Airport,DefaultWeightedEdge> (DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(graph, this.getAllAirports());
		
		List<IntegerPairs> ltemp= dao.getRotteByAirline(airline);
		
		for(IntegerPairs lp : ltemp){
			Airport source=this.mapAirports.get(lp.getSuorceAirport());
			Airport destination=this.mapAirports.get(lp.getDestinationAirport());
			
			if(source!=null && destination!=null){
			DefaultWeightedEdge e =graph.addEdge(source, destination);
			if(e!=null)
			graph.setEdgeWeight(e, LatLngTool.distance(source.getCoords(),destination.getCoords(), LengthUnit.KILOMETER));
			}
		}
	}
	
	public List<Airport> getAereoportiRaggiungibili(Airline airline){
		this.creaGrafo(airline);
		List<Airport> result=new ArrayList<Airport>();
		for(Airport atemp: graph.vertexSet()){
			if(Graphs.neighborListOf(graph, atemp).size()!=0)
				result.add(atemp);
				
		}
		Collections.sort(result);
		return result;
		
		
		
	}
	
	public List<AirportAndDistance> getDistances(Airport airport){
		DepthFirstIterator<Airport,DefaultWeightedEdge> dfi=new DepthFirstIterator<>(graph);
		List<AirportAndDistance> result=new ArrayList<>();
		DijkstraShortestPath<Airport,DefaultWeightedEdge> dsp;
		
		while(dfi.hasNext()){
			Airport prossimo= dfi.next();
			dsp=new DijkstraShortestPath<Airport,DefaultWeightedEdge>(graph, airport,prossimo);
			if(dsp.getPathLength()!= Double.POSITIVE_INFINITY)
			result.add(new AirportAndDistance(prossimo,dsp.getPathLength()));
		}
		
		Collections.sort(result);
		
		 return result;
	}
	 

}
