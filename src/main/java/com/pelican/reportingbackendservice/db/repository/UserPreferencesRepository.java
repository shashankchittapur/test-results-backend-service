package com.pelican.reportingbackendservice.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pelican.reportingbackendservice.domain.db.UserPreference;

public interface UserPreferencesRepository extends JpaRepository<UserPreference, Long> {

}
