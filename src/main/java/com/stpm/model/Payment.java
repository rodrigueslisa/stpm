package com.stpm.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.math.BigDecimal;

@Entity @Table(name="payments")
public class Payment {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne @JoinColumn(name="employer_id")
  private User employer;

  @ManyToOne @JoinColumn(name="project_id")
  private Project project;

  @Column(nullable=false, precision=10, scale=2)
  private BigDecimal amount;

  private Instant paidAt;
  
  public Payment() {
  }

  public Payment(Integer id, User employer, Project project, BigDecimal amount, Instant paidAt) {
      this.id = id;
      this.employer = employer;
      this.project = project;
      this.amount = amount;
      this.paidAt = paidAt;
  }

  public Integer getId() {
      return id;
  }

  public User getEmployer() {
      return employer;
  }

  public Project getProject() {
      return project;
  }

  public BigDecimal getAmount() {
      return amount;
  }

  public Instant getPaidAt() {
      return paidAt;
  }

  public void setId(Integer id) {
      this.id = id;
  }

  public void setEmployer(User employer) {
      this.employer = employer;
  }

  public void setProject(Project project) {
      this.project = project;
  }

  public void setAmount(BigDecimal amount) {
      this.amount = amount;
  }

  public void setPaidAt(Instant paidAt) {
      this.paidAt = paidAt;
  }

  @PrePersist
  public void prePersist() {
      if (paidAt == null) {
          paidAt = Instant.now();
      }
  }
}