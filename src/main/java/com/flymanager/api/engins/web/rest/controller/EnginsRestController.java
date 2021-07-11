package com.flymanager.api.engins.web.rest.controller;

import com.flymanager.api.engins.model.Engin;
import com.flymanager.api.engins.dao.repository.EnginRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.security.RolesAllowed;
import java.net.URI;
import java.util.Date;
import java.util.List;

@Api(tags = "Engins")
@RestController
public class EnginsRestController {

	@Autowired
	private EnginRepository enginRepository;

	@ApiOperation(value = "Retrieve the engins list")
	@GetMapping(value="/engins")
	public List<Engin> getEnginsList() {
		return enginRepository.findAll();
	}

	@ApiOperation(value = "Retrieve an engin")
	@GetMapping(value="/engins/{id}")
	public Engin getEngin(@PathVariable int id) {
		return enginRepository.findById(id);
	}

	@ApiOperation(value = "Create an engin")
	@PostMapping(value = "/engins")
	@RolesAllowed({"INTEGRATOR", "ADMIN"})
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

	@ApiOperation(value = "Update an engin")
	@PutMapping(value = "/engins")
	@RolesAllowed({"INTEGRATOR", "ADMIN"})
	public ResponseEntity<Void> updateEngin(@RequestBody Engin engin) {
		engin.setModificationDate(new Date());

		Engin enginUpdated = enginRepository.save(engin);
		if (enginUpdated == null)
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "Delete an engin")
	@DeleteMapping (value = "/engins")
	@RolesAllowed({"INTEGRATOR", "ADMIN"})
	public void deleteEngin(@RequestBody Engin engin) {
		enginRepository.delete(engin);
	}
}
