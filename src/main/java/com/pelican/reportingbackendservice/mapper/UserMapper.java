package com.pelican.reportingbackendservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pelican.reportingbackendservice.domain.db.User;
import com.pelican.reportingbackendservice.domain.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mapping(target = "name", source = "user.name")
	@Mapping(target = "email", source = "user.email")
	UserDTO toUserDTO(User user);

	@Mapping(target = "name", source = "userDto.name")
	@Mapping(target = "email", source = "userDto.email")
	User fromUserDTO(UserDTO userDto);
}
