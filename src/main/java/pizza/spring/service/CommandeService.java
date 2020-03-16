package pizza.spring.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizza.spring.dao.CommandeDao;
import pizza.spring.dao.PizzaDao;
import pizza.spring.exception.PasDeCommandeSuivanteException;
import pizza.spring.modele.Commande;

@Service
public class CommandeService {
	
	private PizzaDao pizzaDao;
	private CommandeDao commandeDao;
	
	@Autowired
	public CommandeService(PizzaDao pizzaDao, CommandeDao commandeDao) {
		this.pizzaDao = pizzaDao;
		this.commandeDao = commandeDao;
	}

	@Transactional
	public Commande commander(CommandeDto commandeDto) {
		Commande commande = new Commande();
		commande.setNom(commandeDto.getNom());
		commande.setTelephone(commandeDto.getTelephone());
		commande.setEnAttente(true);
		commande.setDateEmission(new Date());
		for(Long id : commandeDto.getPizzaId()) {
			commande.ajouter(pizzaDao.getById(id));
		}
		commandeDao.sauver(commande);
		return commande;
	}

	public Commande getRecap(Long idCommande) {
		return commandeDao.getRecapById(idCommande);
	}

	public Commande getCommandeSuivante() throws PasDeCommandeSuivanteException {
		return commandeDao.getCommandeSuivante();
	}

	public List<Commande> getCommandesEnAttente() {
		return commandeDao.getCommandesEnAttente();
	}

	@Transactional
	public void signalerCommandePrete(Long id) {
		commandeDao.signalerCommandePrete(id);
	}

}
