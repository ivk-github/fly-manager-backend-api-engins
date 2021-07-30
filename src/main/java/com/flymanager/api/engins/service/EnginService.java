package com.flymanager.api.engins.service;

import com.flymanager.api.engins.dto.EnginRequestDTO;
import com.flymanager.api.engins.dto.EnginResponseDTO;

import java.util.List;

public interface EnginService {
	List<EnginResponseDTO> getEnginsList();
	EnginResponseDTO getEnginById(int id);
	EnginResponseDTO createEngin(EnginRequestDTO enginRequestDTO);
	EnginResponseDTO updateEngin(EnginRequestDTO enginRequestDTO);
	void deleteEngin(int id);
}
