package com.flymanager.api.engins.web.controller;

import com.flymanager.api.engins.model.Engin;
import com.flymanager.api.engins.dao.repository.EnginRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
public class EnginController {

	@Autowired
	private EnginRepository enginRepository;

	//Get engins list
	@GetMapping(value="/engins")
	public List<Engin> getEnginsList() {
		return enginRepository.findAll();
	}

	//Get engin by id
	@GetMapping(value="/engins/{id}")
	public Engin getEngin(@PathVariable int id) {
		return enginRepository.findById(id);
	}

	//Create engin
	@PostMapping(value = "/engins")
	public ResponseEntity<Void> createEngin(@RequestBody Engin engin) {
		engin.setCreationDate(new Date());
		engin.setModificationDate(engin.getCreationDate());

		Engin enginCreated = enginRepository.save(engin);
		if (enginCreated == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(enginCreated.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	//Update engin
	@PutMapping(value = "/engins")
	public ResponseEntity<Void> updateEngin(@RequestBody Engin engin) {
		engin.setModificationDate(new Date());

		Engin enginUpdated = enginRepository.save(engin);
		if (enginUpdated == null)
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}

	//Delete engin
	@DeleteMapping (value = "/engins")
	public void deleteEngin(@RequestBody Engin engin) {
		enginRepository.delete(engin);
	}
}
