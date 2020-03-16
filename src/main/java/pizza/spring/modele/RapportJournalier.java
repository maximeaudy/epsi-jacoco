package pizza.spring.modele;

public class RapportJournalier {
	
	private Categorie categorie;
	private long nbPizzas;
	private long montantEncaisse;

	public RapportJournalier(Categorie categorie, long nbPizzas, long montantEncaisse) {
		this.categorie = categorie;
		this.nbPizzas = nbPizzas;
		this.montantEncaisse = montantEncaisse;
	}

	public Categorie getCategorie() {
		return categorie;
	}
	
	public long getMontantEncaisse() {
		return montantEncaisse;
	}
	
	public long getNbPizzas() {
		return nbPizzas;
	}
}
