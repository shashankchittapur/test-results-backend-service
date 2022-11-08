package com.pelican.reportingbackendservice.domain.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractDTO implements Serializable {

	private static final long serialVersionUID = 3203824514642662431L;
	
	private long id;
	
}
