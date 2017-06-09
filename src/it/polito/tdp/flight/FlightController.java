package it.polito.tdp.flight;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.flight.model.Airline;
import it.polito.tdp.flight.model.Airport;
import it.polito.tdp.flight.model.AirportAndDistance;
import it.polito.tdp.flight.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class FlightController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Airline> boxAirline;

    @FXML
    private ComboBox<Airport> boxAirport;

    @FXML
    private TextArea txtResult;

    @FXML
    void doRaggiungibili(ActionEvent event) {
    
    Airport partenza=this.boxAirport.getValue();
    
    if(partenza==null){
    	txtResult.appendText("ERRORE: SElezionare un aereoporto di parteza!");
    	return;
    }
    
    for(AirportAndDistance ad: model.getDistances(partenza)){
    	txtResult.appendText(ad.getAirport().toString()+" "+ad.getDistance()+" Km \n");
    }

    }

    @FXML
    void doServiti(ActionEvent event) {
    	txtResult.clear();
    	Airline airline=this.boxAirline.getValue();
    	if(airline==null){
    		txtResult.appendText("ERRORE: selezionare una compagnia aerea");
    		return;
    	}
    	
    	List<Airport> raggiungibili= model.getAereoportiRaggiungibili(airline);
    	if(raggiungibili.size()==0){
    		txtResult.appendText("WARNING: La compagnia aerea non è più in sevizio\n");
    		return;
    	}
    	
    	
    	for(Airport atemp: raggiungibili){
    		txtResult.appendText(atemp.toString()+"\n");
    	}
    	
    	this.boxAirport.getItems().addAll(raggiungibili);

    }

    @FXML
    void initialize() {
        assert boxAirline != null : "fx:id=\"boxAirline\" was not injected: check your FXML file 'Flight.fxml'.";
        assert boxAirport != null : "fx:id=\"boxAirport\" was not injected: check your FXML file 'Flight.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Flight.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
		this.boxAirline.getItems().addAll(model.getAllLinee());
		
	}
}
