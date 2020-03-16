package pizza.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizza.spring.dao.PizzaDao;
import pizza.spring.modele.Pizza;

@Service
public class PizzaService {

	@Autowired
	private PizzaDao pizzaDao;

	public List<Pizza> getListePizza() {
		return pizzaDao.getListePizza();
	}

}
