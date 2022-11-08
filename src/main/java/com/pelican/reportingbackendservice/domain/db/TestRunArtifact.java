package com.pelican.reportingbackendservice.domain.db;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@JsonInclude(Include.NON_NULL)
@Table(name = "TestRunArtifacts")
@Entity
@NoArgsConstructor
@SuperBuilder
public class TestRunArtifact extends AbstractEntity {

	private static final long serialVersionUID = 4940282315917013242L;

	private Long id;
	private String name;
	private String link;
	private LocalDateTime expiresAt;
	@ManyToOne
	private TestRun testRun;
}
