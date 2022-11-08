package com.pelican.reportingbackendservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pelican.reportingbackendservice.db.repository.UserPreferencesRepository;
import com.pelican.reportingbackendservice.db.repository.UserRepository;
import com.pelican.reportingbackendservice.domain.db.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	@Autowired
	private final UserRepository userRepository;

	@Autowired
	private final UserPreferencesRepository userPreferencesRepository;

	public User createUser(User user) {

		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public Optional<User> getUserByName(String name) {
		return userRepository.findByUserName(name);
	}

	public void deleteUserById(Long id) {
		Optional<User> userById = getUserById(id);
		userById.ifPresent((user) -> userRepository.delete(user));
	}
}
