package org.java.app.db.pojo;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// * RELAZIONE MANY-TO-MANY / N-N - STEP 1 - CREAZIONE TABELLA NEL DB
@Entity
public class Ingredient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

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

  @Override
  public String toString() {
    return "\nIngredient: \nid=" + id + "\nname=" + getName();
  }

  


}
