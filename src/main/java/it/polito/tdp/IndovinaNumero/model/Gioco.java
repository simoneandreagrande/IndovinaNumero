package it.polito.tdp.IndovinaNumero.model;

import it.polito.tdp.IndovinaNumero.model.Gioco.OutcomeGioco;

public class Gioco {
	
	public enum OutcomeGioco{
		Vinto,
		Perso,
		TroppoAlto,
		TroppoBasso
	}
	
	
	//Dati di funzionamneto dell'applicazione
	private int TMax;
	private int NMax;
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

	public void iniziaGioco(Difficolta livello) {
		this.NMax = livello.getNMax();
		this.TMax = livello.getTMax();
		this.NTentativiFatti = 0;
    	this.numeroSegreto = (int)(Math.random()*this.NMax) + 1;
	}
	
	
	/**
	 * Funzione che esegue un tentativo di indovinare il numero segreto
	 * @param tentativo: il numero che tiriamo per indovinare il numero segreto
	 * @return un OutcomeGioco: Vinto se indovinato; Perso se abbiamo esaurito i tentativi senza indovinare (perso);
	 * TroppoAlto se non abbiamo indovinato (ma abbiamo ancora tentativi) ed il numero che 
	 * abbiamo provato e' troppo alto; TroppoBasso se non abbiamo indovinato (ma abbiamo ancora tentativi)
	 * ed il numero provato e' troppo basso
	 */
	public OutcomeGioco faiTentativo(int tentativo) {
		//incrementiamo il numero di tentativi fatti
		this.NTentativiFatti++;
		
		//caso 0: vittoria
    	if (tentativo == this.numeroSegreto) {
    		return OutcomeGioco.Vinto;
    	}
    	
    	//caso 1: sconfitta
    	if (this.NTentativiFatti == this.TMax) {
    		return OutcomeGioco.Perso;
    	}
    	
    	//casi 2/3: non abbiamo indovinato, il numero è troppo alto oppure troppo basso
    	if(tentativo>this.numeroSegreto) {
    		return OutcomeGioco.TroppoAlto;
    	}else  {
    		return OutcomeGioco.TroppoBasso;
    	}
	}
	
}
