package org.java.app.db.pojo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SpecialOffer {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(nullable = false)
  private String title;
  
  @Column(nullable = false)
  private LocalDate startDate; 
  
  @Column(nullable = false)
  private LocalDate endDate;

  // * @ManyToOne
  @ManyToOne // * per ogni offerta speciale esiste una sola pizza
  @JoinColumn(nullable = false) // * un'offerta speciale non può esistere senza una pizza
  private Pizza pizza;

  public SpecialOffer() {}

  public SpecialOffer(int id, String title, LocalDate startDate, LocalDate endDate, Pizza pizza) {
		
    setTitle(title);
		setStartDate(startDate);
		setEndDate(endDate);
    setPizza(pizza);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public Pizza getPizza() {
    return pizza;
  }

  public void setPizza(Pizza pizza) {
    this.pizza = pizza;
  }

  @Override
  public String toString() {
    return "SpecialOffer:\nid=" + id + "\ntitle=" + title + "\nstartDate=" + startDate + "\nendDate=" + endDate;
  }

  
  
}
