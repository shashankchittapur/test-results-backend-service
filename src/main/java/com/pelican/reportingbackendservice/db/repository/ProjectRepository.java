package com.pelican.reportingbackendservice.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pelican.reportingbackendservice.domain.db.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	Optional<Project> findByName(String name);
}
