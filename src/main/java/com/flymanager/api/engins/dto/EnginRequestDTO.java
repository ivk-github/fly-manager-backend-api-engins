package com.flymanager.api.engins.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EnginRequestDTO {
	private int id;
	private String registrationNumber;
	private String type;
	private String brand;
	private String model;
	private int available;
	private double hourlyRate;
	private Date creationDate;
	private int creationUser;
	private Date modificationDate;
	private int modificationUser;

	public EnginRequestDTO(int id, String registrationNumber, String type) {
		this.id = id;
		this.registrationNumber = registrationNumber;
		this.type = type;
	}

	public EnginRequestDTO(String registrationNumber, String type) {
		this.registrationNumber = registrationNumber;
		this.type = type;
	}
}
