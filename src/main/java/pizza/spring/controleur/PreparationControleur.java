package pizza.spring.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pizza.spring.exception.PasDeCommandeSuivanteException;
import pizza.spring.service.CommandeService;

@Controller
public class PreparationControleur {
	
	@Autowired
	private CommandeService commandeService;

	@GetMapping("/preparation")
	public String afficherCommandeEnAttente(Model model) {
		model.addAttribute("commandes", commandeService.getCommandesEnAttente());
		return "liste-commandes";
	}

	@GetMapping("/suivante")
	public String afficherCommandeSuivante(Model model) {
		try {
			model.addAttribute("commande", commandeService.getCommandeSuivante());
			return "commande-suivante";
		} catch (PasDeCommandeSuivanteException e) {
			return afficherCommandeEnAttente(model);
		}
	}

	@PostMapping("/suivante")
	public String signalerCommandePrete(@RequestParam Long id) {
		commandeService.signalerCommandePrete(id);
		return "redirect:/preparation";
	}
}
