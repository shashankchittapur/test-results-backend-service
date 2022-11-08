package com.pelican.reportingbackendservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pelican.reportingbackendservice.documented.controller.UserDocumentedContoller;
import com.pelican.reportingbackendservice.domain.db.User;
import com.pelican.reportingbackendservice.domain.dto.UserDTO;
import com.pelican.reportingbackendservice.mapper.UserMapper;
import com.pelican.reportingbackendservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController implements UserDocumentedContoller {

	@Autowired
	private final UserService userService;

	@Autowired
	private final UserMapper userMapper;

	@Autowired
	public UserController(UserService userService, UserMapper userMapper) {
		super();
		this.userService = userService;
		this.userMapper = userMapper;
	}

	@PostMapping()
	public UserDTO createUser(@RequestBody UserDTO userDto) {
		User createUser = userService.createUser(userMapper.fromUserDTO(userDto));
		return userMapper.toUserDTO(createUser);
	}

}
