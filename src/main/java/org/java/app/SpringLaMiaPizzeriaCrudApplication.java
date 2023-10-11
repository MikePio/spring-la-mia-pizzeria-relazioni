package org.java.app;

import org.java.app.db.pojo.Pizza;
import org.java.app.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// * STEP 6 vengono creati gli oggetti con i propri dati che verranno inseriti come righe della tabella nel database
// * implementare CommandLineRunner
// * aggiungere @Autowired private PizzaService pizzaService;
// * creare nel metodo run degli oggetti
@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{

	@Autowired
	private PizzaService pizzaService;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Pizza margherita = new Pizza("Margherita", "Pomodoro e mozzarella", "margherita.jpg", 5.00f);
		Pizza cotto = new Pizza("Prosciutto Cotto", "Pomodoro, mozzarella e prosciutto cotto", "cotto.jpg", 6.50f);
		Pizza diavola = new Pizza("Diavola", "Pomodoro, mozzarella e salame piccante", "diavola.jpg", 7.00f);
	
		pizzaService.save(margherita);
		pizzaService.save(cotto);
		pizzaService.save(diavola);
		
		System.out.println("\n\nDati inseriti nella tabella del database\n\n");
	}

}
