package pizza.spring.dao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import pizza.spring.modele.Fidelisation;
import pizza.spring.modele.RapportJournalier;

@Repository
public class RapportDao {
	
	@PersistenceContext
	private EntityManager em;

	public List<Fidelisation> getRapportFidelisation() {
		return em.createQuery("select new pizza.spring.modele.Fidelisation(c.nom, count(c)) "
							+ "from Commande c "
							+ "group by c.nom "
							+ "order by c.nom", Fidelisation.class)
				 .getResultList();
	}

	public List<RapportJournalier> getRapportJournalier() {
		LocalDate now = LocalDate.now();
		Date startDate = Date.from(now.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		Date endDate = Date.from(now.plusDays(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		return em.createQuery("select new pizza.spring.modele.RapportJournalier(c, count(d.pizza), sum(p.prix)) "
							+ "from DetailCommande d "
							+ "left join d.pizza p "
							+ "left join p.categorie c "
							+ "where d.commande.dateEmission >= :startDate "
							+ "and d.commande.dateEmission < :endDate "
							+ "group by c "
							+ "order by c.nom", RapportJournalier.class)
				 .setParameter("startDate", startDate)
				 .setParameter("endDate", endDate)
				 .getResultList();
	}
}
