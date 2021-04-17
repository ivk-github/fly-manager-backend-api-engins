package com.flymanager.api.engins.dao.repository;

import com.flymanager.api.engins.model.Engin;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EnginRepository extends JpaRepository<Engin, Integer> {

	Engin findById(int id);
}
