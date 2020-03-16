package pizza.spring.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pizza.spring.service.RapportService;

@Controller
public class RapportControleur {
	
	@Autowired
	private RapportService rapportService;
	
	@GetMapping("/fidelisation")
	public String getRapportFidelisation(Model model) {
		model.addAttribute("fidelisation", rapportService.getRapportFidelisation());
		return "rapport-fidelisation";
	}

	@GetMapping("/rapport")
	public String getRapportJournalier(Model model) {
		model.addAttribute("rapport", rapportService.getRapportJournalier());
		return "rapport-journalier";
	}
}
