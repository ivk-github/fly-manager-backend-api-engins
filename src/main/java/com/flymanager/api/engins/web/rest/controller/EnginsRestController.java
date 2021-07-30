package com.flymanager.api.engins.web.rest.controller;

import com.flymanager.api.engins.dto.EnginRequestDTO;
import com.flymanager.api.engins.dto.EnginResponseDTO;
import com.flymanager.api.engins.service.EnginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.annotation.security.RolesAllowed;
import java.net.URI;
import java.util.List;

@Slf4j
@Api(tags = "Engins")
@RestController
@RequestMapping("/engins")
@RefreshScope
public class EnginsRestController {

	private EnginService enginService;

	public EnginsRestController(EnginService enginService) {
		this.enginService = enginService;
	}

	@ApiOperation(value = "Retrieve the engins list")
	@GetMapping
	public ResponseEntity<List<EnginResponseDTO>> getEnginsList() {
		log.info("Get engins list");
		List<EnginResponseDTO> engins = enginService.getEnginsList();
	//	return new ResponseEntity<>(engins, HttpStatus.OK);
		return ResponseEntity.ok().body(engins);
	}

	@ApiOperation(value = "Retrieve an engin")
	@GetMapping("/{id}")
	public ResponseEntity<EnginResponseDTO> getEnginById(@PathVariable("id") int id) {
		EnginResponseDTO engin = enginService.getEnginById(id);
		return ResponseEntity.ok().body(engin);
	}

	@ApiOperation(value = "Create an engin")
	@PostMapping
	@RolesAllowed({"INTEGRATOR", "ADMIN"})
	public ResponseEntity<EnginResponseDTO> createEngin(@RequestBody EnginRequestDTO engin) {
		EnginResponseDTO enginCreated = enginService.createEngin(engin);

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
	public ResponseEntity<EnginResponseDTO> updateEngin(@RequestBody EnginRequestDTO engin) {
		EnginResponseDTO enginUpdated = enginService.updateEngin(engin);

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
