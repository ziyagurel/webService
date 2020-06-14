package com.ziyagurel.hoaxify.webService.error;

import java.util.Date;
import java.util.Map;

import lombok.Data;

@Data
public class ResponseError {
	private int status;
	private String message;
	private String path;
	private long timestamp = new Date().getTime();
	private Map<String, String> validationErrors;
	
	public ResponseError(int status, String message, String path) {
		this.status = status;
		this.message = message;
		this.path = path;
	}
	
	
	
	
}
