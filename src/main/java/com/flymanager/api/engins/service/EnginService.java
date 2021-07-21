package com.flymanager.api.engins.service;

import com.flymanager.api.engins.dao.repository.EnginRepository;
import com.flymanager.api.engins.exception.EnginNotFoundException;
import com.flymanager.api.engins.model.Engin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EnginService {

	@Autowired
	private EnginRepository enginRepository;

	public List<Engin> getEnginsList() {
		return enginRepository.findAll();
	}

	public Engin getEnginById(int id) {
		return enginRepository.findById(id)
				.orElseThrow(() -> new EnginNotFoundException("Engin [" + id +"] doesn't exist"));
	}

	public Engin createEngin(Engin engin) {
		engin.setCreationDate(new Date());
		engin.setModificationDate(engin.getCreationDate());
		return enginRepository.save(engin);
	}

	public Engin updateEngin(Engin engin) {
		engin.setModificationDate(new Date());
		return enginRepository.save(engin);
	}

	public void deleteEngin(int id) {
		enginRepository.deleteById(id);
	}
}
