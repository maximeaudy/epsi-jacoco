package pizza.spring.modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String telephone;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEmission;
	private boolean enAttente;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "commande", fetch = FetchType.EAGER)
	private List<DetailCommande> details = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDateEmission() {
		return dateEmission;
	}

	public void setDateEmission(Date dateEmission) {
		this.dateEmission = dateEmission;
	}

	public boolean isEnAttente() {
		return enAttente;
	}

	public void setEnAttente(boolean enAttente) {
		this.enAttente = enAttente;
	}

	public List<DetailCommande> getDetails() {
		return details;
	}

	public void setDetails(List<DetailCommande> details) {
		this.details = details;
	}
	
	public void ajouter(Pizza pizza) {
		DetailCommande detailCommande = new DetailCommande();
		detailCommande.setPizza(pizza);
		detailCommande.setCommande(this);
		this.details.add(detailCommande);
	}

}
