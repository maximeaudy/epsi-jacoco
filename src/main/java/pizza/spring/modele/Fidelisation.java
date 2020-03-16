package pizza.spring.modele;

public class Fidelisation {

	private String nomClient;
	private long nbCommandes;

	public Fidelisation(String nomClient, long nbCommandes) {
		this.nomClient = nomClient;
		this.nbCommandes = nbCommandes;
	}

	public String getNomClient() {
		return nomClient;
	}
	
	public long getNbCommandes() {
		return nbCommandes;
	}
}
