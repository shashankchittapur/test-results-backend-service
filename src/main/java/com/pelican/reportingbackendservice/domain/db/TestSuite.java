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
@Table(name = "TestSuites")
@Entity
@NoArgsConstructor
@SuperBuilder
public class TestSuite extends AbstractEntity {
	private static final long serialVersionUID = 7092110226778467099L;

	private String name;
	private String fileName;
	private String description;
	@ManyToOne
	private User user;
	@OneToOne
	private TestRun testRun;

}
