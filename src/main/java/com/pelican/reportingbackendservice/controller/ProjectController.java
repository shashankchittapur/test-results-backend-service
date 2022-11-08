package com.pelican.reportingbackendservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pelican.reportingbackendservice.documented.controller.ProjectDocumentedController;
import com.pelican.reportingbackendservice.domain.db.Project;
import com.pelican.reportingbackendservice.domain.dto.ProjectDTO;
import com.pelican.reportingbackendservice.mapper.ProjectMapper;
import com.pelican.reportingbackendservice.service.ProjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "api/projects", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ProjectController extends AbstractController implements ProjectDocumentedController {

	private final ProjectMapper projectMapper;
	private final ProjectService projectService;

	@PostMapping
	@Override
	public ProjectDTO createProject(@RequestBody ProjectDTO project) {
		Project fromProjectDTO = projectMapper.fromProjectDTO(project);
		Project newProject = projectService.createProject(fromProjectDTO);
		ProjectDTO projectDTO = projectMapper.toProjectDTO(newProject);
		return projectDTO;
	}

	@Override
	@DeleteMapping("/{id}")
	public void deleteProject(@PathVariable("id") long id) {
		projectService.deleteProjectById(id);

	}

	@Override
	@PutMapping
	public ProjectDTO updateProject(@RequestBody ProjectDTO project) {
		Project updatedProject = projectService.updateProject(projectMapper.fromProjectDTO(project));
		return projectMapper.toProjectDTO(updatedProject);
	}

	@Override
	@GetMapping()
	public List<ProjectDTO> getAllProjects() {
		return projectService.getAllProjects().stream().map(project -> projectMapper.toProjectDTO(project))
				.collect(Collectors.toList());
	}

	@GetMapping("/{name}")
	@Override
	public ProjectDTO getProjectByName(@PathVariable("name") String name) {
		return projectMapper.toProjectDTO(projectService.getProjectByName(name));
	}

}
