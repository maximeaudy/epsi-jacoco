package pizza.spring.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import pizza.spring.dao.CommandeDao;
import pizza.spring.dao.PizzaDao;
import pizza.spring.modele.Commande;
import pizza.spring.modele.Pizza;

public class CommandeServiceTest {
	
	private PizzaDao pizzaDaoMock;
	private CommandeDao commandeDaoMock;
	private CommandeService commandeService;

	@Before
	public void initService() {
		pizzaDaoMock = mock(PizzaDao.class);
		commandeDaoMock = mock(CommandeDao.class);
		commandeService = new CommandeService(pizzaDaoMock, commandeDaoMock);
	}
	
	@Test
	public void commander_ajoute_une_pizza_dans_la_commande() throws Exception {
		Pizza pizza = new Pizza();
		when(pizzaDaoMock.getById(1L)).thenReturn(pizza);
		CommandeDto commandeDto = new CommandeDto();
		commandeDto.getPizzaId().add(1L);
		
		Commande commande = commandeService.commander(commandeDto);
		
		assertEquals(pizza, commande.getDetails().get(0).getPizza());
	}

	@Test
	public void commander_positionne_le_nom_et_le_telephone() throws Exception {
		CommandeDto commandeDto = new CommandeDto();
		commandeDto.setNom("nom");
		commandeDto.setTelephone("0606060606");
		
		Commande commande = commandeService.commander(commandeDto);
		
		assertEquals("nom", commande.getNom());
		assertEquals("0606060606", commande.getTelephone());
	}

	@Test
	public void commander_cree_une_commande_en_attente_avec_une_date() throws Exception {
		CommandeDto commandeDto = new CommandeDto();
		
		Commande commande = commandeService.commander(commandeDto);
		
		assertTrue(commande.isEnAttente());
		assertNotNull(commande.getDateEmission());
	}

	@Test
	public void commander_sauve_la_commande() throws Exception {
		CommandeDto commandeDto = new CommandeDto();
		
		Commande commande = commandeService.commander(commandeDto);
		
		verify(commandeDaoMock).sauver(commande);
	}
}
