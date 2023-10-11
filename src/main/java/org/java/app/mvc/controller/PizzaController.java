package org.java.app.mvc.controller;

import java.util.List;

import org.java.app.db.pojo.Pizza;
import org.java.app.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

// * STEP 7 - inizializzazione progetto - creare le rotte per mostrare nelle view i dati
// scrivere @Controller
// scrivere @Autowired private PizzaService pizzaService;
// creare le rotte index e show
// creare in templates i file index(pizza-index) e show(pizza-show)
@Controller
public class PizzaController {

  @Autowired
  private PizzaService pizzaService;

  // @GetMapping("/")
  @GetMapping
  public String getHome(Model model) {

    return "home";
    
    // List<Pizza> pizzas = pizzaService.findAll();
    // model.addAttribute("pizzas", pizzas);
    
    // * per far mostrare l'indice delle pizze anche quando l'url è "/"
    // return "pizza-index";
  }
  
  
  // ! STEP 3(FINALE) PER CERCARE UN OGGETTO TRAMITE FORM
  // AGGIUNGERE , @RequestParam(required = false) String pizzaName
  // AGGIUNGERE IN   @GetMapping("/pizzas") le successive 2 righe in basso ↓
  // List<Pizza> pizzas = pizzaName == null ? pizzaService.findAll() : pizzaService.findByName(pizzaName);                  
  // model.addAttribute("pizzas", pizzas);
  @GetMapping("/pizzas")
  public String getIndex(Model model, @RequestParam(required = false) String pizzaName) {   // * STEP 3(FINALE) parte 1 PER CERCARE UN OGGETTO TRAMITE FORM

    
    // senza ricerca
    // List<Pizza> pizzas = pizzaService.findAll();
    // model.addAttribute("pizzas", pizzas);

    // sintassi estesa
    // if(pizzaName == null){
      
    //   List<Pizza> pizzas = pizzaService.findAll();
    //   model.addAttribute("pizzas", pizzas);
    // }else{
      
    //   // * findByName perché il campo salvato nel db è name (se invece fosse stato title allora findByTitle)
    //   List<Pizza> pizzas = pizzaService.findByName(pizzaName);
    //   model.addAttribute("pizzas", pizzas);
    // }

      // * STEP 3(FINALE) parte 2 PER CERCARE UN OGGETTO TRAMITE FORM
      // sintassi con il ternario  
      List<Pizza> pizzas = pizzaName == null
                        ? pizzaService.findAll()
      // * findByName perché il campo salvato nel db è name (se invece fosse stato title allora findByTitle)
                        : pizzaService.findByName(pizzaName);
                        
      model.addAttribute("pizzas", pizzas);

    return "pizza-index";
  }

  @GetMapping("/pizzas/{id}")
  public String getShow(@PathVariable int id, Model model) {

    Pizza pizza = pizzaService.findById(id);
    model.addAttribute("pizza", pizza);

    return "pizza-show";
  }

  @GetMapping("/credits")
  public String credits(Model model){

    return "credits";
  }

  // * step 2 - Validazione errori - creare la rotta del create e la view(/file.html) 
  @GetMapping("/pizza-create")
  public String getCreateForm(Model model){
    
    model.addAttribute("pizza", new Pizza());

    return "pizza-create";
  }
  // * step 4 - Validazione errori - aggiungere @Valid e BindingResult bindingResult per stampare gli errori
  @PostMapping("/pizza-create") // reindirizzamento al click del button submit nel create
  public String store(@Valid @ModelAttribute Pizza pizza, BindingResult bindingResult, Model model) {
    
    System.out.println("\nAdded new pizza:\n" + pizza);

    // Validazione e stampa errori per il create
    if(bindingResult.hasErrors()){
      System.out.println("Error: ");
      bindingResult.getAllErrors().forEach(System.out::println);

      return "pizza-create";
    }else{
      System.out.println("No error\n");
    }

    // * step ultimo step - creazione oggetto/Validazione errori - salvataggio dell'oggetto nel db
    try {
			pizzaService.save(pizza);
		} catch (DataIntegrityViolationException e) {
			
			// CONSTRAIN VALIDATION (unique)
			System.out.println("Error: " + e.getClass().getSimpleName());
			
			model.addAttribute("name_unique", "The name must be unique");
			
			return "pizza-create";
		}

    return "redirect:/pizzas";
  }

  // * EDIT - STEP 1 - controller + link nell'index e nella show + creazione pizza-update.html(view)
  @GetMapping("/pizzas/update/{id}")
  public String getPizzaUpdate(@PathVariable int id, Model model){

    Pizza pizza = pizzaService.findById(id);
		model.addAttribute("pizza", pizza);

    return "pizza-update";
  }
  // * EDIT - STEP 3 - aggiungere il post mapping 
  @PostMapping("/pizzas/update/{id}")
  public String updatePizza(@Valid @ModelAttribute Pizza pizza, BindingResult bindingResult, Model model){

    System.out.println("\nUpdate pizza:\n" + pizza);

    // Validazione e stampa errori per l'edit
    if(bindingResult.hasErrors()){
      System.out.println("Error: ");
      bindingResult.getAllErrors().forEach(System.out::println);

      return "pizza-update";
    }else{
      System.out.println("No error\n");
    }

    // * EDIT - (ULTIMO) STEP 4 - salvataggio dell'oggetto nel db
    try {
			pizzaService.save(pizza);
		} catch (DataIntegrityViolationException e) {
			
			// CONSTRAIN VALIDATION (unique)
			System.out.println("Error: " + e.getClass().getSimpleName());
			
			model.addAttribute("name_unique", "The name must be unique. There is already a pizza called this way");
			
			return "pizza-update";
		}
    
    return "redirect:/pizzas";
  }
  // * DELETE - STEP 2 - implementare nel controller il metodo delete di PizzaService il metodo e creare il form per l'eliminazione 
	@PostMapping("/pizzas/delete/{id}")
	public String deletePizza(@PathVariable int id) {
		
		Pizza pizza = pizzaService.findById(id);
		pizzaService.deletePizza(pizza);
		
		return "redirect:/pizzas";
	}

}
