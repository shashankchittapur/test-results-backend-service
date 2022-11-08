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
@Table(name = "Jobs")
@Entity
@NoArgsConstructor
@SuperBuilder
public class Job extends AbstractEntity {

	private static final long serialVersionUID = -7136622077881406856L;

	private String name;
	private String jobURL;
	private String jenkinsHost;
	private Long automationServerId;
	@ManyToOne
	private User user;
	@OneToOne
	private TestRun testRun;
}
