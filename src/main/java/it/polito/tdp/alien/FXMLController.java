package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Traduttore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bttClear;

    @FXML
    private Button bttTranslate;

    @FXML
    private TextField txtInput;

    @FXML
    private TextArea txtOutput;
    
    private Traduttore traduttore = new Traduttore();

    @FXML
    void bttHandler(ActionEvent event) {
    	
    	if ( this.txtInput.getText().contains(" ")) {
    		
    		String [] parole = this.txtInput.getText().split(" ");
    		try {
    		traduttore.inserisciParola(parole[0],parole[1]);
    		this.txtInput.clear();
    		} 
    		catch (IllegalArgumentException e) {
    			this.txtOutput.appendText(e.getMessage());
    		}
    	}
    	else {
    		if (traduttore.traduciParola(this.txtInput.getText().toLowerCase())==null) {
    			this.txtOutput.appendText("parola non tradotta"+'\n');
    		}
    		else{
    			for (String s : this.traduttore.traduciParola(this.txtInput.getText())) {
    				this.txtOutput.appendText(s+",");
    			}
    		}
    	}

    }
    
    @FXML
    void clear(ActionEvent event) {
    	this.txtInput.clear();
    	this.txtOutput.clear();

    }

    @FXML
    void initialize() {
        assert bttTranslate != null : "fx:id=\"bttTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert bttClear != null : "fx:id=\"bttClear\" was not injected: check your FXML file 'Scene.fxml'.";
    }

}
