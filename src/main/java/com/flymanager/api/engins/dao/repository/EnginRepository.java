package com.flymanager.api.engins.dao.repository;

import com.flymanager.api.engins.model.Engin;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface EnginRepository extends JpaRepository<Engin, Integer> {

	Optional<Engin> findById(int id);
	void deleteById(int id);
}
