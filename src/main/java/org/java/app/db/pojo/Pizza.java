package org.java.app.db.pojo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;

// * FASE 3 CREARE LA TABELLA NEL DATABASE
// * eseguire il programma e controllare se è stata creata la tabella nel db (DBeaver, MariaDB, PHPMyAdmin...)
@Entity
public class Pizza {
  
  // * step 5 - Validazione errori - scrivere messaggi di errore custom
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // id della tabella
  private int id;

  // campi della tabella da inserire: nome descrizione foto prezzo
  @Column(length = 128, nullable = false, unique = true)
  @Length(min = 2, max = 128, message = "\nThe length must be between 2 and 128 characters" )
  private String name;

	private String description;
  
  @NotBlank(message = "\nEnter the name of the image followed by the format (e.g. name.jpg, name.png...)")
	private String photo;

  @Column(nullable = false, unique = false)
  @Range(min = 1, max = 1000, message = "\nThe price must be between €1 and €1000" )
  // @DecimalMin(value = "1.00", message = "\nThe price must be at least €1")
  // @DecimalMax(value = "1000.00", message = "\nThe price must be at most €1000")
  private float price;
  
  // costruttore
  public Pizza() { }
	public Pizza(String name, String description, String photo, float price) {

		setId(id);
		setName(name);
		setDescription(description);
		setPhoto(photo);
		setPrice(price);
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

	public String getFormattedPrice() {
		return String.format("%.2f", price);
	}

  @Override
  public String toString() {
		return "Id: " + getId() + "\n" + "Name: " + getName() + "\n" + "Description: " + getDescription() + "\n" + "Image path: " + getPhoto() + "\n" + "Price: " + getPrice() + " ----> Formatted Price: " + getFormattedPrice() + "\n";
  }

}
