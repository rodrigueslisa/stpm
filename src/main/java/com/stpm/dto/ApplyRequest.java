package com.stpm.dto;
import jakarta.validation.constraints.*;

public class ApplyRequest {
  @NotNull private Long projectId;
  @NotNull private Long studentId;
  
  public ApplyRequest() {
  }

  public ApplyRequest(Long projectId, Long studentId) {
      this.projectId = projectId;
      this.studentId = studentId;
  }

  public Long getProjectId() {
      return projectId;
  }

  public Long getStudentId() {
      return studentId;
  }

  public void setProjectId(Long projectId) {
      this.projectId = projectId;
  }

  public void setStudentId(Long studentId) {
      this.studentId = studentId;
  }
}