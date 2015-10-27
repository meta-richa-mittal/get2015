package com.car.exception;

public class CarSystemException extends CarException {

	public CarSystemException(String message) {
		super(message);
	}

	public CarSystemException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
