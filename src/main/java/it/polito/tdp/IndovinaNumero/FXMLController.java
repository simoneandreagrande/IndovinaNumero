/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.IndovinaNumero;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.IndovinaNumero.model.Difficolta;
import it.polito.tdp.IndovinaNumero.model.Gioco;
import it.polito.tdp.IndovinaNumero.model.Gioco.OutcomeGioco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ComboBox;

public class FXMLController {
	
	Gioco model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnNuovaPartita"
    private Button btnNuovaPartita; // Value injected by FXMLLoader

    @FXML // fx:id="barTentativi"
    private ProgressBar barTentativi; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnProva"
    private Button btnProva; // Value injected by FXMLLoader

    @FXML // fx:id="txtCom"
    private TextArea txtCom; // Value injected by FXMLLoader

    @FXML // fx:id="txtNmax"
    private TextField txtNMax; // Value injected by FXMLLoader

    @FXML // fx:id="txtProva"
    private TextField txtProva; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultato"
    private TextArea txtRisultato; // Value injected by FXMLLoader

    @FXML // fx:id="txtTentativi"
    private TextField txtTentativi; // Value injected by FXMLLoader

    @FXML // fx:id="txtTmax"
    private TextField txtTMax; // Value injected by FXMLLoader
    
    @FXML
    private ComboBox<Difficolta> comboDifficolta;

    @FXML
    void doNuovaPartita(ActionEvent event) {
    	// inizializzare variabili del gioco, reset del gioco
//    	try {
//    		this.TMax = Integer.parseInt(this.txtTMax.getText()); // parseInt per convertire stringa a intero
//    	}catch(NumberFormatException e) {
//    		this.txtCom.setText("TMax deve essere un numero!");
//    	}
//    	try {
//    		this.NMax = Integer.parseInt(this.txtNMax.getText()); // parseInt per convertire stringa a intero
//    	}catch(NumberFormatException e) {
//    		this.txtCom.setText("NMax deve essere un numero!");
//    	}
//    	
    	Difficolta livello = comboDifficolta.getValue();
    	model.iniziaGioco(livello);
    	
    	
    	// aggiornamento interfaccia grafica
    	this.txtTentativi.setText(Integer.toString(this.model.getTMax()-this.model.getNTentativiFatti()));
    	// stampa numeroSegreto in area risultato
    	// this.txtRisultato.setText(Integer.toString(numeroSegreto));
    	this.txtNMax.setText(Integer.toString(this.model.getNMax()));
    	this.txtTMax.setText(Integer.toString(this.model.getTMax()));
    	this.btnProva.setDisable(false);
    	this.txtRisultato.clear();
    	this.txtProva.clear();
    	this.txtCom.clear();
    	this.barTentativi.setProgress(0);
    }

    @FXML
    void doProva(ActionEvent event) {
    	// leggere numero scelto, uso parseInt per convertire stringa in numero
    	int guess;
    	this.txtCom.clear();
    	try {
    		guess = Integer.parseInt(this.txtProva.getText());
    	}catch(NumberFormatException e) {
    		this.txtCom.setText("Inserire un numero");
    		return;
    	}
    	
    	
    	// fare controlli su numero, ad esempio che rispetti il range
//    	
//    	if (guess <= NMax && guess >= 0) {
//    		
//    	} else {
//    		this.txtCom.setText("Inserire un numero tra 0 e " + this.NMax);
//    		return;
//    	}
    	
    	
    	
    	// chiamare il modlello per effettuare il tentativo
    	Gioco.OutcomeGioco risultato = this.model.faiTentativo(guess);
    	
    	// aggiornamento dell'interfaccia grafica
    	this.txtTentativi.setText(Integer.toString(this.model.getTMax()-this.model.getNTentativiFatti()));
    	this.barTentativi.setProgress((double)this.model.getNTentativiFatti()/this.model.getTMax());
    	
    	// cosa succede sul gioco, provare a giocare, riprendo ciò che ho scritto nella classe Gioco
    	
    	if (risultato ==  Gioco.OutcomeGioco.Vinto) {
    		this.txtRisultato.appendText("Hai vinto! Il numero segreto era " + this.model.getNumeroSegreto() + "\n"); // append.Text scrive sotto le informazioni, senza cancellare quelle precedenti come setText
    		this.btnProva.setDisable(true);
    		return;
    	}
    	
    	if(risultato == Gioco.OutcomeGioco.Perso) {
    		this.txtRisultato.appendText("Hai perso! Il numero segreto era " + this.model.getNumeroSegreto() + "\n");
    		this.btnProva.setDisable(true);
    		return;
    	}
    	
    	if (risultato == Gioco.OutcomeGioco.TroppoAlto) {
    		this.txtRisultato.appendText("Numero troppo alto!\n");
    	} else { // risultato == 3, ultimo caso possibile
    		this.txtRisultato.appendText("Numero troppo basso!\n");
    	}		 
    		
   
    	 
    	
    	
    	

    }
    
    
    // set model
    public void setModel(Gioco model) {
    	this.model = model;
    }
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert barTentativi != null : "fx:id=\"barTentativi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnNuovaPartita != null : "fx:id=\"btnNuovaPartita\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnProva != null : "fx:id=\"btnProva\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCom != null : "fx:id=\"txtCom\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNMax != null : "fx:id=\"txtNmax\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtProva != null : "fx:id=\"txtProva\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTMax != null : "fx:id=\"txtTmax\" was not injected: check your FXML file 'Scene.fxml'.";
       
        this.comboDifficolta.getItems().add(new Difficolta(Difficolta.Livello.Facile));
        this.comboDifficolta.getItems().add(new Difficolta(Difficolta.Livello.Medio));
        this.comboDifficolta.getItems().add(new Difficolta(Difficolta.Livello.Difficile));
    }
    

}
