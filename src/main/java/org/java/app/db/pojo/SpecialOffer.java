package org.java.app.db.pojo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

  public SpecialOffer() {}

  public SpecialOffer(int id, String title, LocalDate startDate, LocalDate endDate) {
		
    setTitle(title);
		setStartDate(startDate);
		setEndDate(endDate);
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

  @Override
  public String toString() {
    return "SpecialOffer:\nid=" + id + "\ntitle=" + title + "\nstartDate=" + startDate + "\nendDate=" + endDate;
  }

  
  
}
