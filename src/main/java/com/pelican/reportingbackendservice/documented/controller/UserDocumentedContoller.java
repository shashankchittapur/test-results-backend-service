package com.pelican.reportingbackendservice.documented.controller;

import com.pelican.reportingbackendservice.domain.dto.UserDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("User API")
public interface UserDocumentedContoller {

	@ApiOperation(value = "Creates a user", notes = "Returns the created user", nickname = "createUser", httpMethod = "POST", response = UserDTO.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "Authorization", paramType = "header", required = true, value = "The auth token (Bearer)"),
			@ApiImplicitParam(name = "user", paramType = "body", dataType = "UserDTO", required = true, value = "The User to create") })
	@ApiResponses({ @ApiResponse(code = 200, message = "Returns the created User", response = UserDTO.class) })
	UserDTO createUser(UserDTO userDto);

}
