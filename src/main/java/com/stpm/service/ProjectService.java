package com.stpm.service;

import com.stpm.dto.ProjectRequest;
import com.stpm.model.Project;
import com.stpm.model.User;
import com.stpm.repository.ProjectRepository;
import com.stpm.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
  private final ProjectRepository projects;
  private final UserRepository users;

  public ProjectService(ProjectRepository projects, UserRepository users) {
    this.projects = projects;
    this.users = users;
  }

  public Project create(ProjectRequest req) {
    User employer = users.findById(req.getEmployerId())
        .orElseThrow(() -> new IllegalArgumentException("Employer not found"));
    
    Project p = new Project();
    p.setTitle(req.getTitle());
    p.setDescription(req.getDescription());
    p.setEmployer(employer);
    
    return projects.save(p);
  }
}