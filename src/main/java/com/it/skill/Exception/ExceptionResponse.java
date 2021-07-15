package com.it.skill.Exception;

import java.util.Date;

public class ExceptionResponse {

	private Date dateAndTime;

	private String message;

	private String details;

	public ExceptionResponse(Date dateAndTime, String message, String details) {
		super();
		this.dateAndTime = dateAndTime;
		this.message = message;
		this.details = details;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
