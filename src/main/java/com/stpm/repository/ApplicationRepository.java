package com.stpm.repository;
import com.stpm.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ApplicationRepository extends JpaRepository<Application, Long> {}