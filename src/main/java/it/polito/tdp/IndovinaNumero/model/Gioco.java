package it.polito.tdp.IndovinaNumero.model;

public class Gioco {
	
	public enum StatoGioco{
		Vinto,
		Perso,
		TroppoAlto,
		TRoppoBasso
	}
	
	

	private final int TMax = 8;
	private final int NMax = 100;
	private int NTentativiFatti;
	private int numeroSegreto;
	
	public int getTMax() {
		return TMax;
	}
	
	public int getNMax() {
		return NMax;
	}
	
	public int getNTentativiFatti() {
		return NTentativiFatti;
	}
	
	public int getNumeroSegreto() {
		return numeroSegreto;
	}
	
	
	
	public void iniziaGioco() {
		this.NTentativiFatti = 0;
    	this.numeroSegreto = (int)(Math.random()*this.NMax) + 1;
//    	try {
//    		this.TMax = Integer.parseInt(this.txtTMax.getText());
//    	}catch(NumberFormatException e) {
//    		this.txtCom.setText("TMax deve eseere un numero!");
//    	}
//    	
//    	try {
//    		this.NMax = Integer.parseInt(this.txtNMax.getText());
//    	}catch(NumberFormatException e) {
//    		this.txtCom.setText("NMax deve eseere un numero!");
//    	}
	}
	
	/**
	 * Funzione che esegue un tentativo del gioco
	 * @return Resituisce 0 se abbiamo vinto, 1 se abbiamo perso
	 * 2 se il numero è troppo alto, 3 se il numero è troppo basso
	 */
	public StatoGioco faiTentativo(int tentativo) {
		//incrementare numero tentativi fatti
    	this.NTentativiFatti++;
    		
    	//giocare
    	if (tentativo == this.numeroSegreto) {
    		return StatoGioco.Vinto;
    	}
    	
    	if (this.NTentativiFatti == this.TMax) {
    		return StatoGioco.Perso;
    	}
    	
    	if(tentativo > this.numeroSegreto) {
    		return StatoGioco.TroppoAlto;
    	}else  {
    		return StatoGioco.TRoppoBasso;
    	}
    	
	}
	
	
	
}
