package it.polito.tdp.IndovinaNumero.model;

public class Gioco {
	
	// classe con integer statici a cui sono associati queste label
	public enum OutcomeGioco {
		Vinto,
		Perso,
		TroppoAlto,
		TroppoBasso
	}
	
	

	// Dati di funzionamento dell'applicazione
	private int TMax; // log in base 2 di 100 (tentativi massimi)
	private int NMax; // final indica una costante
	private int NTentativiFatti; // tentativi fatti dall'utente
	private int numeroSegreto; // numero segreto calcolato randomicamente dal computer
	
	
	

	
	public int getNTentativiFatti() {
		return NTentativiFatti;
	}



	public void setNTentativiFatti(int nTentativiFatti) {
		NTentativiFatti = nTentativiFatti;
	}



	public int getNumeroSegreto() {
		return numeroSegreto;
	}


	public void setNumeroSegreto(int numeroSegreto) {
		this.numeroSegreto = numeroSegreto;
	}


	public int getTMax() {
		return TMax;
	}


	public int getNMax() {
		return NMax;
	}






	public void iniziaGioco(Difficolta livello) {
		
		this.NMax = livello.getNMax();
		this.TMax = livello.getTMax();
		this.NTentativiFatti = 0;
    	this.numeroSegreto = (int)(Math.random()*this.NMax) + 1; // Math.random() restituisce un numero casuale tra 0 e 1 (1 escluso);

	
    	
    	    	
	}
	
	
	
	/**
	 * Funzione che esegue un tentativo di indovinare il numero segreto
	 * 
	 * @param tentativo: il numero che tiriamo per indovinare il numero segreto
	 * @return un enum OutcomeGioco: Vinto se indovinato, Perso se eseurito i tentativi senza indovinare,
	 * TroppoAlto se non abbiamo indovinato ma abbiamo ancora tentativi e il numero è troppo alto,
	 * TroppoBasso se non abbiamo indovinato ma abbiamo ancora tentativi e il numero è troppo basso.
	 */
	public OutcomeGioco faiTentativo(int tentativo) {
		// incrementiamo il numero di tentativi fatti
		this.NTentativiFatti++;
		
		// caso 0: vittoria
		if (tentativo ==  numeroSegreto) {
    		return OutcomeGioco.Vinto;
    	}
    	
		// caso 1; sconfitta
    	if(this.NTentativiFatti == this.TMax) {
    		return OutcomeGioco.Perso;
    	}
    	
    	// caso 2/3: non abbiamo indovinato e il numero è troppo alto oppure troppo basso
    	
    	if (tentativo>this.numeroSegreto) {
    		return OutcomeGioco.TroppoAlto
    				;
    	} else {
    		return OutcomeGioco.TroppoBasso;
    	}
    		
		
	}
}
