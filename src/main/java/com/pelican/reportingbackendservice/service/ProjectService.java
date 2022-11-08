package com.pelican.reportingbackendservice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pelican.reportingbackendservice.db.repository.ProjectRepository;
import com.pelican.reportingbackendservice.domain.db.Project;
import com.pelican.reportingbackendservice.service.exception.ResourceNotFoundException;

@Service
public class ProjectService {

	public static final String DEFAULT_PROJECT = "UNKNOWN";

	private static final String ERR_MSG_PROJECT_NOT_FOUND_BY_NAME = "NO COMPANY FOUND WITH NAME '%s'";

	private static final String ERR_MSG_PROJECT_NOT_FOUND_BY_ID = "NO COMPANY FOUND WITH ID '%d'";

	private final ProjectRepository projectRepository;

	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	@Transactional(rollbackFor = Exception.class)
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}

	@Transactional(readOnly = true)
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Project getProjectByName(String name) {
		return projectRepository.findByName(name).orElseThrow(() -> new ResourceNotFoundException(
				ResourceNotFoundException.ResourceNotFoundErrorDetail.PROJECT_NOT_FOUND,
				String.format(ERR_MSG_PROJECT_NOT_FOUND_BY_NAME, name)));
	}

	@Transactional(readOnly = true)
	public Project getProjectById(Long id) {
		return projectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(
						ResourceNotFoundException.ResourceNotFoundErrorDetail.PROJECT_NOT_FOUND,
						String.format(ERR_MSG_PROJECT_NOT_FOUND_BY_ID, id)));
	}

	@Transactional(rollbackFor = Exception.class)
	public void deleteProjectById(long id) {
		projectRepository.delete(getProjectById(id));
	}

	@Transactional(rollbackFor = Exception.class)
	public Project updateProject(Project project) {
		return projectRepository.save(project);
	}

	public static String getDefaultProject() {
		return DEFAULT_PROJECT;
	}

}
