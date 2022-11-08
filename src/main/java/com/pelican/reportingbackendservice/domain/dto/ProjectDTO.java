package com.pelican.reportingbackendservice.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ProjectDTO extends AbstractDTO {

	private static final long serialVersionUID = 6621311958743823917L;
	
	private String name;
	private String description;
}
