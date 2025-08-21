package com.stpm.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity @Table(name="feedback")
public class Feedback {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne @JoinColumn(name="project_id")
  private Project project;

  @ManyToOne @JoinColumn(name="giver_id")
  private User giver;

  @ManyToOne @JoinColumn(name="receiver_id")
  private User receiver;

  @Column(nullable=false)
  private Integer rating; // 1..5

  @Lob
  private String comments;

  private Instant createdAt;
  
  public Feedback() {
  }

  public Feedback(Integer id, Project project, User giver, User receiver, Integer rating, String comments, Instant createdAt) {
      this.id = id;
      this.project = project;
      this.giver = giver;
      this.receiver = receiver;
      this.rating = rating;
      this.comments = comments;
      this.createdAt = createdAt;
  }

  public Integer getId() {
      return id;
  }

  public Project getProject() {
      return project;
  }

  public User getGiver() {
      return giver;
  }

  public User getReceiver() {
      return receiver;
  }

  public Integer getRating() {
      return rating;
  }

  public String getComments() {
      return comments;
  }

  public Instant getCreatedAt() {
      return createdAt;
  }

  public void setId(Integer id) {
      this.id = id;
  }

  public void setProject(Project project) {
      this.project = project;
  }

  public void setGiver(User giver) {
      this.giver = giver;
  }

  public void setReceiver(User receiver) {
      this.receiver = receiver;
  }

  public void setRating(Integer rating) {
      this.rating = rating;
  }

  public void setComments(String comments) {
      this.comments = comments;
  }

  public void setCreatedAt(Instant createdAt) {
      this.createdAt = createdAt;
  }

  @PrePersist
  public void prePersist() {
      if (createdAt == null) {
          createdAt = Instant.now();
      }
  }
}