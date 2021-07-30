package com.flymanager.api.engins.mapper;

import com.flymanager.api.engins.dto.EnginRequestDTO;
import com.flymanager.api.engins.dto.EnginResponseDTO;
import com.flymanager.api.engins.model.Engin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EnginMapper {
	Engin enginRequestDTOToEngin(EnginRequestDTO enginRequestDTO);
	EnginResponseDTO enginToEnginResponseDTO(Engin engin);
}
