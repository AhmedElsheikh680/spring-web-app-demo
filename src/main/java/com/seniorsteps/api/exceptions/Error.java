package com.seniorsteps.api.exceptions;

import java.util.UUID;

public class Error {

	private String traceCode=UUID.randomUUID().toString();
	private String code;
	private String message;
	
	public Error(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public String getTraceCode() {
		return traceCode;
	}
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	
}
