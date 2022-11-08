package com.pelican.reportingbackendservice.domain.db;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@JsonInclude(Include.NON_NULL)
@Table(name = "TestRuns")
@Entity
@NoArgsConstructor
@SuperBuilder
public class TestRun extends AbstractEntity {

	private static final long serialVersionUID = -4836919365877300620L;

	@ElementCollection(targetClass = String.class)
	@MapKeyColumn(name = "Run_Configuration")
	private Map<String, String> configuration = new HashMap<>();
	private String ciRunId;
	@ManyToOne
	private User user;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "testRun")
	private TestSuite testSuite;
	private Status status;
	private String scmURL;
	private String scmBranch;
	private String scmCommit;
	@JsonIgnore
	private String configXML;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "testRun")
	private WorkItem workItem;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "testRun")
	private Job job;
	private Integer buildNumber;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "testRun")
	private Job upstreamJob;
	private Integer upstreamJobBuildNumber;
	private Initiator startedBy;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "testRun")
	private Project project;
	private boolean knownIssue;
	private boolean blocker;
	private Date startedAt;
	private Date endedAt;
	private Integer elapsed;
	private Integer eta;
	private String comments;
	private String channels;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "testRun")
	private TestConfig config;

	private Integer passed;
	private Integer failed;
	private Integer failedAsKnown;
	private Integer failedAsBlocker;
	private Integer skipped;
	private Integer inProgress;
	private Integer aborted;
	private Integer queued;
	private boolean reviewed;
	private String framework;

	@OneToMany(mappedBy = "testRun", cascade = CascadeType.ALL)
	private Set<TestRunArtifact> artifacts = new HashSet<>();

	public enum Initiator {
		SCHEDULER, UPSTREAM_JOB, HUMAN
	}

}
