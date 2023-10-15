package org.java.app.db.pojo;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

// * RELAZIONE MANY-TO-MANY / N-N - STEP 1 - CREAZIONE TABELLA NEL DB
@Entity
public class Ingredient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  // * RELAZIONE MANY-TO-MANY / N-N - STEP 2.2/2.2 - COLLEGAMENTO DELLE TABELLE in Pizza.java e poi in Ingredient.java
  @ManyToMany(mappedBy = "ingredients")
  private List<Pizza> pizzas;

  private String name;

  public Ingredient(){}

  public Ingredient(String name){
    
    setName(name);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // * RELAZIONE MANY-TO-MANY / N-N - STEP 4.1/4.5 - COLLEGARE GLI ID DELLE PIZZE CON GLI ID DEGLI INGREDIENTI NELLA TABELLA db_pizzeria_relationships DEL DB --> creare getter e setter di Pizza in Ingredient
  // * getter e setter di Pizza 
  public List<Pizza> getPizzas() {
    return pizzas;
  }

  public void setPizzas(List<Pizza> pizzas) {
    this.pizzas = pizzas;
  }

  @Override
  public String toString() {
    return "\nIngredient: \nid=" + id + "\nname=" + getName();
  }

  


}
