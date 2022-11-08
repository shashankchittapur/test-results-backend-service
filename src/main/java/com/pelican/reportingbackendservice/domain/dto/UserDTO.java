package com.pelican.reportingbackendservice.domain.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.pelican.reportingbackendservice.domain.db.UserPreference;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class UserDTO extends AbstractDTO {


	private String name;
	private String email;
	private List<UserPreference> preferences = new ArrayList<>();

}
