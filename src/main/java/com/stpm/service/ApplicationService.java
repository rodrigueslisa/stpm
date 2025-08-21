package com.stpm.service;

import com.stpm.dto.ApplyRequest;
import com.stpm.model.*;
import com.stpm.repository.*;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
  private final ApplicationRepository applications;
  private final ProjectRepository projects;
  private final UserRepository users;

  public ApplicationService(ApplicationRepository a, ProjectRepository p, UserRepository u) {
    this.applications = a; this.projects = p; this.users = u;
  }

  public Application apply(ApplyRequest req) {
    Project project = projects.findById(req.getProjectId())
        .orElseThrow(() -> new IllegalArgumentException("Project not found"));
    User student = users.findById(req.getStudentId())
        .orElseThrow(() -> new IllegalArgumentException("Student not found"));
    Application app = new Application();
    app.setProject(project);
    app.setStudent(student);
    app.setStatus(ApplicationStatus.PENDING);
    
    return applications.save(app);
  }
}