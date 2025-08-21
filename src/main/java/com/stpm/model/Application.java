package com.stpm.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity @Table(name="applications")
public class Application {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(optional=false) @JoinColumn(name="project_id")
  private Project project;

  @ManyToOne(optional=false) @JoinColumn(name="student_id")
  private User student;

  @Enumerated(EnumType.STRING)
  private ApplicationStatus status;

  private Instant appliedAt;
  
  public Application() {
  }

  public Application(Integer id, Project project, User student, ApplicationStatus status, Instant appliedAt) {
      this.id = id;
      this.project = project;
      this.student = student;
      this.status = status;
      this.appliedAt = appliedAt;
  }

  public Integer getId() {
      return id;
  }

  public Project getProject() {
      return project;
  }

  public User getStudent() {
      return student;
  }

  public ApplicationStatus getStatus() {
      return status;
  }

  public Instant getAppliedAt() {
      return appliedAt;
  }

  public void setId(Integer id) {
      this.id = id;
  }

  public void setProject(Project project) {
      this.project = project;
  }

  public void setStudent(User student) {
      this.student = student;
  }

  public void setStatus(ApplicationStatus status) {
      this.status = status;
  }

  public void setAppliedAt(Instant appliedAt) {
      this.appliedAt = appliedAt;
  }

  @PrePersist
  public void prePersist() {
      if (status == null) {
          status = ApplicationStatus.PENDING;
      }
      if (appliedAt == null) {
          appliedAt = Instant.now();
      }
  }
}