package com.flymanager.api.engins.web.rest.controller;

import com.flymanager.api.engins.model.Engin;
import com.flymanager.api.engins.service.EnginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.security.RolesAllowed;
import java.net.URI;
import java.util.List;

@Api(tags = "Engins")
@RestController
@RequestMapping("/engins")
@RefreshScope
public class EnginsRestController {

	@Autowired
	private EnginService enginService;

	@ApiOperation(value = "Retrieve the engins list")
	@GetMapping
	public ResponseEntity<List<Engin>> getEnginsList() {
		List<Engin> engins = enginService.getEnginsList();
	//	return new ResponseEntity<>(engins, HttpStatus.OK);
		return ResponseEntity.ok().body(engins);
	}

	@ApiOperation(value = "Retrieve an engin")
	@GetMapping("/{id}")
	public ResponseEntity<Engin> getEnginById(@PathVariable("id") int id) {
		Engin engin = enginService.getEnginById(id);
		return ResponseEntity.ok().body(engin);
	}

	@ApiOperation(value = "Create an engin")
	@PostMapping
	@RolesAllowed({"INTEGRATOR", "ADMIN"})
	public ResponseEntity<Engin> createEngin(@RequestBody Engin engin) {
		Engin enginCreated = enginService.createEngin(engin);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(enginCreated.getId())
				.toUri();
	//	return ResponseEntity.created(location).build();
		return ResponseEntity.created(location).body(enginCreated);
	}

	@ApiOperation(value = "Update an engin")
	@PutMapping
	@RolesAllowed({"INTEGRATOR", "ADMIN"})
	public ResponseEntity<Engin> updateEngin(@RequestBody Engin engin) {
		Engin enginUpdated = enginService.updateEngin(engin);

	//	return ResponseEntity.ok().build();
		return ResponseEntity.ok().body(enginUpdated);
	}

	@ApiOperation(value = "Delete an engin")
	@DeleteMapping("/{id}")
	@RolesAllowed({"INTEGRATOR", "ADMIN"})
	public ResponseEntity<Void> deleteEngin(@PathVariable("id") int id) {
		enginService.deleteEngin(id);
		return ResponseEntity.ok().build();
	}
}
