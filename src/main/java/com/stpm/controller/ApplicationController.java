package com.stpm.controller;

import com.stpm.dto.ApplyRequest;
import com.stpm.model.Application;
import com.stpm.repository.ApplicationRepository;
import com.stpm.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
  private final ApplicationService service;
  private final ApplicationRepository applications;

  public ApplicationController(ApplicationService service, ApplicationRepository applications) {
    this.service = service; this.applications = applications;
  }

  @PostMapping("/apply")
  public ResponseEntity<Application> apply(@Valid @RequestBody ApplyRequest req) {
    Application saved = service.apply(req);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }

  @GetMapping
  public List<Application> list() { return applications.findAll(); }
}