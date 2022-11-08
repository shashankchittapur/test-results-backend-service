package com.pelican.reportingbackendservice.domain.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@JsonInclude(Include.NON_NULL)
@Table(name = "WorkItems")
@Entity
@NoArgsConstructor
@SuperBuilder
public class WorkItem extends AbstractEntity {

	private static final long serialVersionUID = 2233484378732049507L;
	
	private String issueId;
	private String description;
	private boolean blocker;
	private Integer hashCode;
	private Long testCaseId;
	@ManyToOne
	private User user;
	@OneToOne
	private TestRun testRun;
	
}
