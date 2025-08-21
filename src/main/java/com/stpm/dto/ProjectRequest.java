package com.stpm.dto;

import jakarta.validation.constraints.*;

public class ProjectRequest {
  @NotBlank private String title;
  private String description;
  @NotNull private Long employerId; // userId of EMPLOYER
  
  public ProjectRequest() {
  }

  public ProjectRequest(String title, String description, Long employerId) {
      this.title = title;
      this.description = description;
      this.employerId = employerId;
  }

  public String getTitle() {
      return title;
  }

  public String getDescription() {
      return description;
  }

  public Long getEmployerId() {
      return employerId;
  }

  public void setTitle(String title) {
      this.title = title;
  }

  public void setDescription(String description) {
      this.description = description;
  }

  public void setEmployerId(Long employerId) {
      this.employerId = employerId;
  }
}