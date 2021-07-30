package com.flymanager.api.engins.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Engin {

	@ApiModelProperty(position=1, value="Technical ID (unique, auto-generated)")
	@Id
	@GeneratedValue
	private int id;

	@ApiModelProperty(position=2, value="Registration number (unique)")
	private String registrationNumber;

	@ApiModelProperty(position=3, value="Type")
	private String type;

	@ApiModelProperty(position=4, value="Brand")
	private String brand;

	@ApiModelProperty(position=5, value="Model")
	private String model;

	@ApiModelProperty(position=6, value="Available", allowableValues="0,1")
	private int available;

	@ApiModelProperty(position=7, value="Hourly rate")
	private double hourlyRate;

	@ApiModelProperty(position=8, value="Creation date")
	private Date creationDate;

	@ApiModelProperty(position=9, value="Creation user ID")
	private int creationUser;

	@ApiModelProperty(position=10, value="Modification date")
	private Date modificationDate;

	@ApiModelProperty(position=11, value="Modification user ID")
	private int modificationUser;

	public Engin(int id, String registrationNumber, String type) {
		this.id = id;
		this.registrationNumber = registrationNumber;
		this.type = type;
	}
}
