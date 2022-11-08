package com.pelican.reportingbackendservice.domain.db;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "User_Preferences")
@JsonInclude(Include.NON_NULL)
public class UserPreference extends AbstractEntity {

	private static final long serialVersionUID = -9041105145990837479L;

	@Enumerated
	private Name name;
	private String value;
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public enum Name {
		DEFAULT_DASHBOARD, DEFAULT_TEST_VIEW, REFRESH_INTERVAL, THEME
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserPreference that = (UserPreference) o;
		return name == that.name && Objects.equals(value, that.value) && Objects.equals(user.getId(), that.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, value, user.getId());
	}
}
