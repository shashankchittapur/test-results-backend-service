package com.pelican.reportingbackendservice.domain.db.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "key", "value" })
public class Argument {
	@XmlElement(required = true)
	protected String key;

	@XmlAttribute(name = "unique")
	protected boolean unique;

	@XmlElement(required = true)
	protected String value;

	public Argument() {
	}

	public Argument(String key, String value) {
		this.key = key;
		this.value = value;
	}
}
