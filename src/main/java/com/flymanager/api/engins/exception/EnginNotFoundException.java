package com.flymanager.api.engins.exception;

public class EnginNotFoundException extends RuntimeException {
	public EnginNotFoundException(String message) {
		super(message);
	}
}
