package com.stpm.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity @Table(name="submissions")
public class Submission {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(optional=false) @JoinColumn(name="application_id")
  private Application application;

  private String fileUrl;
  
  private Instant submittedAt;
  
  public Submission() {
  }

  public Submission(Integer id, Application application, String fileUrl, Instant submittedAt) {
      this.id = id;
      this.application = application;
      this.fileUrl = fileUrl;
      this.submittedAt = submittedAt;
  }

  public Integer getId() {
      return id;
  }

  public Application getApplication() {
      return application;
  }

  public String getFileUrl() {
      return fileUrl;
  }

  public Instant getSubmittedAt() {
      return submittedAt;
  }

  public void setId(Integer id) {
      this.id = id;
  }

  public void setApplication(Application application) {
      this.application = application;
  }

  public void setFileUrl(String fileUrl) {
      this.fileUrl = fileUrl;
  }

  public void setSubmittedAt(Instant submittedAt) {
      this.submittedAt = submittedAt;
  }

  @PrePersist
  public void prePersist() {
      if (submittedAt == null) {
          submittedAt = Instant.now();
      }
  }
}