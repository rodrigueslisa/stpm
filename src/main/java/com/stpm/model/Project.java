package com.stpm.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity @Table(name="projects")
public class Project {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable=false, length=200)
  private String title;

  @Lob
  private String description;

  @ManyToOne
  @JoinColumn(name="employer_id")
  private User employer;

  private Instant postedAt;
  
  public Project() {
  }

  public Project(Integer id, String title, String description, User employer, Instant postedAt) {
      this.id = id;
      this.title = title;
      this.description = description;
      this.employer = employer;
      this.postedAt = postedAt;
  }

  public Integer getId() {
      return id;
  }

  public String getTitle() {
      return title;
  }

  public String getDescription() {
      return description;
  }

  public User getEmployer() {
      return employer;
  }

  public Instant getPostedAt() {
      return postedAt;
  }

  public void setId(Integer id) {
      this.id = id;
  }

  public void setTitle(String title) {
      this.title = title;
  }

  public void setDescription(String description) {
      this.description = description;
  }

  public void setEmployer(User employer) {
      this.employer = employer;
  }

  public void setPostedAt(Instant postedAt) {
      this.postedAt = postedAt;
  }

  @PrePersist
  public void prePersist() {
      if (postedAt == null) {
          postedAt = Instant.now();
      }
  }
}