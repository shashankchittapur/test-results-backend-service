package com.pelican.reportingbackendservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pelican.reportingbackendservice.domain.db.Project;
import com.pelican.reportingbackendservice.domain.dto.ProjectDTO;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
	@Mapping(target = "name", source = "project.name")
	@Mapping(target = "description", source = "project.description")
	ProjectDTO toProjectDTO(Project project);

	@Mapping(target = "name", source = "projectDTO.name")
	@Mapping(target = "description", source = "projectDTO.description")
	Project fromProjectDTO(ProjectDTO projectDTO);
}
