package org.java.app.mvc.controller;

import java.util.List;

import org.java.app.db.pojo.Ingredient;
import org.java.app.db.serv.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

// * RELAZIONE MANY-TO-MANY / N-N - STEP 5.1/5.2 - STAMPARE IN PAGINA GLI INGREDIENTI (/OGGETTI) ---> creare un controller con all'interno una rotta che porta al file index e cerare un file index -->
@Controller
// @RequestMapping serve per inserire ingredients in modo automatico senza doverol scrivere in ogni rotta
// @RequestMapping("/ingredients") 
public class IngredientController {
  
	@Autowired
	private IngredientService ingredientService;

  // * INDEX
	// @GetMapping // con @RequestMapping scritto in alto
  @GetMapping("/ingredients") // senza @RequestMapping scritto in alto (in questo caso l'ho commentato)
	public String getIndex(Model model) {

    List<Ingredient> ingredients = ingredientService.findAll();
		model.addAttribute("ingredients", ingredients);

		return "ingredient-index";
	}

  // * CREATE
  @GetMapping("/ingredients-create")
	public String getCreateForm(Model model) {
		
		model.addAttribute("ingredient", new Ingredient());
		
		return "ingredient-create";
	}
	@PostMapping("/ingredients-create")
	public String storeNewIngredient(@Valid @ModelAttribute Ingredient ingredient, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			
			return "ingredient-create";
		}
		
		ingredientService.save(ingredient);
		
		return "redirect:/ingredients";
	}
}
