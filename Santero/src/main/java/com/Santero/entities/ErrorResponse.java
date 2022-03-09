package com.Santero.entities;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date timeStamp;
	
	private int code;
	private String status;
	private String message;
	private String stackTrace;
	private Object data;
	
	public ErrorResponse() {
        timeStamp = new Date();
    }

    public ErrorResponse(HttpStatus httpStatus, String message) {    	
        this();    
        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
    }

    public ErrorResponse( HttpStatus httpStatus, String message, String stackTrace) {
        this( httpStatus, message);
        this.stackTrace = stackTrace;
    }

    public ErrorResponse(HttpStatus httpStatus, String message, String stackTrace, Object data) {
        this(httpStatus, message, stackTrace);
        this.data = data;
    }

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}       
		
}
