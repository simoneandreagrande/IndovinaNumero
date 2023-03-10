/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.IndovinaNumero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ProgressBar;

public class FXMLController {
	
	
	private int TMax;
	private int NMax;
	private int NTentativiFatti;
	private int numeroSegreto;
	

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnNuovaPartita"
    private Button btnNuovaPartita; // Value injected by FXMLLoader

    @FXML // fx:id="btnPRova"
    private Button btnPRova; // Value injected by FXMLLoader

    @FXML // fx:id="txtCom"
    private TextArea txtCom; // Value injected by FXMLLoader

    @FXML // fx:id="txtNMax"
    private TextField txtNMax; // Value injected by FXMLLoader

    @FXML // fx:id="txtProva"
    private TextField txtProva; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultato"
    private TextArea txtRisultato; // Value injected by FXMLLoader

    @FXML // fx:id="txtTMax"
    private TextField txtTMax; // Value injected by FXMLLoader

    @FXML // fx:id="txtTentativi"
    private TextField txtTentativi; // Value injected by FXMLLoader
    
    @FXML // fx:id="barTentativi"
    private ProgressBar barTentativi; // Value injected by FXMLLoader

    @FXML
    void doNuovaPartita(ActionEvent event) {
    	//inizializzare variabili del gioco
    	this.NTentativiFatti = 0;
    	this.numeroSegreto = (int)(Math.random()*this.NMax) + 1;
    	try {
    		this.TMax = Integer.parseInt(this.txtTMax.getText());
    	}catch(NumberFormatException e) {
    		this.txtCom.setText("TMax deve eseere un numero!");
    	}
    	
    	try {
    		this.NMax = Integer.parseInt(this.txtNMax.getText());
    	}catch(NumberFormatException e) {
    		this.txtCom.setText("NMax deve eseere un numero!");
    	}
    	
    	//scrivere informazioni utente
    	this.txtTentativi.setText( Integer.toString(this.TMax-this.NTentativiFatti) );
    	this.txtNMax.setText(Integer.toString(this.NMax) );
    	this.txtTMax.setText(Integer.toString(this.TMax));
//    	this.txtRisultato.setText(Integer.toString(numeroSegreto));
    	
    	this.btnPRova.setDisable(false);
    	this.txtRisultato.clear();
    	this.txtProva.clear();
    	this.txtCom.clear();
    	
    	this.barTentativi.setProgress(0);

    }

    @FXML
    void doProva(ActionEvent event) {
    	//leggere numero scelto
    	int guess;
    	try {
    		guess = Integer.parseInt(this.txtProva.getText());
    	}catch(NumberFormatException e) {
    		this.txtCom.setText("inserire un numero!");
    		return;
    	}
    	
    	
    	//fare controlli sul numero
    	
    	//incrementare numero tentativi fatti
    	this.NTentativiFatti++;
    	
    	this.txtTentativi.setText( Integer.toString(this.TMax-this.NTentativiFatti) );
    	this.barTentativi.setProgress((double) this.NTentativiFatti / this.TMax);
    	
    	//giocare
    	if (guess == this.numeroSegreto) {
    		this.txtRisultato.appendText("Hai vinto. Il numero segreto era " + this.numeroSegreto + "\n");
    		this.btnPRova.setDisable(true);
    		return;
    	}
    	
    	if (this.NTentativiFatti == this.TMax) {
    		this.txtRisultato.appendText("Hai perso. Il numero segreto era " + this.numeroSegreto + "\n");
    		this.btnPRova.setDisable(true);
    		return;
    	}
    	
    	if(guess>this.numeroSegreto) {
    		this.txtRisultato.appendText("Numero troppo alto\n");
    	}else  {
    		this.txtRisultato.appendText("Numero tropo basso\n");
    	}
    	
    	
    	
    }
    
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnNuovaPartita != null : "fx:id=\"btnNuovaPartita\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnPRova != null : "fx:id=\"btnPRova\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCom != null : "fx:id=\"txtCom\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNMax != null : "fx:id=\"txtNMax\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtProva != null : "fx:id=\"txtProva\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTMax != null : "fx:id=\"txtTMax\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
