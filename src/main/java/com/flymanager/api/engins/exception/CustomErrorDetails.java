package com.flymanager.api.engins.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class CustomErrorDetails {
	private Date timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
}
