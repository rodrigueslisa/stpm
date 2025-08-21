package com.stpm.controller;

import com.stpm.dto.ProjectRequest;
import com.stpm.model.Project;
import com.stpm.repository.ProjectRepository;
import com.stpm.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
  private final ProjectService service;
  private final ProjectRepository projects;

  public ProjectController(ProjectService service, ProjectRepository projects) {
    this.service = service; this.projects = projects;
  }

  @PostMapping
  public ResponseEntity<Project> create(@Valid @RequestBody ProjectRequest req) {
    Project p = service.create(req);
    return ResponseEntity.status(HttpStatus.CREATED).body(p);
  }

  @GetMapping
  public List<Project> list() { return projects.findAll(); }

  @GetMapping("/{id}")
  public ResponseEntity<Project> get(@PathVariable Long id) {
    return projects.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }
}