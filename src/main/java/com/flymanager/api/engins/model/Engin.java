package com.flymanager.api.engins.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Engin {

	@Id
	@GeneratedValue
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

	public Engin() {
	}

	public Engin(int id, String registrationNumber, String type, String brand, String model, int available, double hourlyRate, Date creationDate, int creationUser, Date modificationDate, int modificationUser) {
		this.id = id;
		this.registrationNumber = registrationNumber;
		this.type = type;
		this.brand = brand;
		this.model = model;
		this.available = available;
		this.hourlyRate = hourlyRate;
		this.creationDate = creationDate;
		this.creationUser = creationUser;
		this.modificationDate = modificationDate;
		this.modificationUser = modificationUser;
	}

	public Engin(int id, String registrationNumber, String type) {
		this.id = id;
		this.registrationNumber = registrationNumber;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(int creationUser) {
		this.creationUser = creationUser;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public int getModificationUser() {
		return modificationUser;
	}

	public void setModificationUser(int modificationUser) {
		this.modificationUser = modificationUser;
	}

	@Override
	public String toString() {
		return "Engin{" +
				"id=" + id +
				", registrationNumber='" + registrationNumber + '\'' +
				", type='" + type + '\'' +
				", brand='" + brand + '\'' +
				", model='" + model + '\'' +
				", available=" + available +
				", hourlyRate=" + hourlyRate +
				", creationDate=" + creationDate +
				", creationUser=" + creationUser +
				", modificationDate=" + modificationDate +
				", modificationUser=" + modificationUser +
				'}';
	}
}
