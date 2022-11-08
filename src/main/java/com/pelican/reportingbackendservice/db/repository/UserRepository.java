package com.pelican.reportingbackendservice.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pelican.reportingbackendservice.domain.db.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByUserName(String name);
}
