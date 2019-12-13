package com.flightservices;

public class APIError {
	
	private Integer status;
	private String error;
	private String exception;
	private String message;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public APIError(Integer status, String error, String exception, String message) {
		super();
		this.status = status;
		this.error = error;
		this.exception = exception;
		this.message = message;
	}
	
	
	

}
