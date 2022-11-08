package com.pelican.reportingbackendservice.domain.db;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@JsonInclude(Include.NON_NULL)
@Table(name = "Projects")
@Entity
@NoArgsConstructor
@SuperBuilder
public class Project extends AbstractEntity {

	private static final long serialVersionUID = 1289532916434812308L;

	private String name;
	private String description;
	@OneToOne
	private TestRun testRun;

}
