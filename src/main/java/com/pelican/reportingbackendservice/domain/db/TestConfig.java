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
@Table(name = "TestConfigs")
@Entity
@NoArgsConstructor
@SuperBuilder
public class TestConfig extends AbstractEntity {

	private static final long serialVersionUID = 5668009693004786533L;

	private String url;
	private String env;
	private String platform;
	private String platformVersion;
	private String browser;
	private String browserVersion;
	private String appVersion;
	private String locale;
	private String language;
	private String device;
	@OneToOne
	private TestRun testRun;
}
