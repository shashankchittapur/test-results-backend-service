package com.pelican.reportingbackendservice.domain.db;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Index;
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
@Table(name = "Users", indexes = @Index(name = "userName_unique", columnList = "username"))
@JsonInclude(Include.NON_NULL)
public class User extends AbstractEntity implements Comparable<User> {

	private static final long serialVersionUID = -8137084078629789927L;

	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Date lastLogin;
	private String coverPhotoUrl;
	private UserStatus status = UserStatus.ACTIVE;
	private String resetToken;


	@Override
	public int compareTo(User user) {
		return userName.compareTo(user.getUserName());
	}
	
}
