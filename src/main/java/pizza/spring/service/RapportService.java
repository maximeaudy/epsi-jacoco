package pizza.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizza.spring.dao.RapportDao;
import pizza.spring.modele.Fidelisation;
import pizza.spring.modele.RapportJournalier;

@Service
public class RapportService {

	@Autowired
	private RapportDao RapportDao;

	public List<Fidelisation> getRapportFidelisation() {
		return RapportDao.getRapportFidelisation();
	}

	public List<RapportJournalier> getRapportJournalier() {
		return RapportDao.getRapportJournalier();
	}
}
