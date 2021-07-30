package com.flymanager.api.engins.service;

import com.flymanager.api.engins.dao.repository.EnginRepository;
import com.flymanager.api.engins.dto.EnginRequestDTO;
import com.flymanager.api.engins.dto.EnginResponseDTO;
import com.flymanager.api.engins.exception.ResourceNotFoundException;
import com.flymanager.api.engins.mapper.EnginMapper;
import com.flymanager.api.engins.model.Engin;
import com.flymanager.api.engins.util.Translator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EnginServiceImpl implements EnginService {

	private EnginMapper enginMapper;
	private EnginRepository enginRepository;

	public EnginServiceImpl(EnginMapper enginMapper, EnginRepository enginRepository) {
		this.enginMapper = enginMapper;
		this.enginRepository = enginRepository;
	}

	@Override
	public List<EnginResponseDTO> getEnginsList() {
		List<Engin> engins = enginRepository.findAll();
		List<EnginResponseDTO> enginResponseDTOList =
				engins.stream()
					.map(engin -> enginMapper.enginToEnginResponseDTO(engin))
					.collect(Collectors.toList());
		return enginResponseDTOList;
	}

	@Override
	public EnginResponseDTO getEnginById(int id) {
		Engin engin = enginRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Engin [" + id +"] doesn't exist"));
				.orElseThrow(() -> new ResourceNotFoundException(
						Translator.translate(
							"com.flymanager.api.exception.NotFound.message",
								new Object[]{id})));

		EnginResponseDTO enginResponseDTO = enginMapper.enginToEnginResponseDTO(engin);
		return enginResponseDTO;
	}

	@Override
	public EnginResponseDTO createEngin(EnginRequestDTO enginRequestDTO) {
		Engin engin = enginMapper.enginRequestDTOToEngin(enginRequestDTO);

		engin.setCreationDate(new Date());
		engin.setModificationDate(engin.getCreationDate());
		Engin enginCreated = enginRepository.save(engin);

		EnginResponseDTO enginResponseDTO = enginMapper.enginToEnginResponseDTO(enginCreated);
		return enginResponseDTO;
	}

	@Override
	public EnginResponseDTO updateEngin(EnginRequestDTO enginRequestDTO) {
		Engin engin = enginMapper.enginRequestDTOToEngin(enginRequestDTO);

		engin.setModificationDate(new Date());
		Engin enginUpdated = enginRepository.save(engin);

		EnginResponseDTO enginResponseDTO = enginMapper.enginToEnginResponseDTO(enginUpdated);
		return enginResponseDTO;
	}

	@Override
	public void deleteEngin(int id) {
		enginRepository.deleteById(id);
	}
}
