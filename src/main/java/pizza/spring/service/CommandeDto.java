package pizza.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class CommandeDto {
	
	@Size(min = 1, message = "Vous devez choisir au moins une pizza")
	private List<Long> pizzaId = new ArrayList<>();
	@NotBlank
	private String nom;
	@NotBlank
	private String telephone;

	public List<Long> getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(List<Long> pizzaId) {
		this.pizzaId = pizzaId;
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

}
