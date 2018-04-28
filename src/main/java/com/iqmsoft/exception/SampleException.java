package com.iqmsoft.exception;

public class SampleException extends Exception {
	
	private static final long serialVersionUID = -9018314580566395780L;

	public SampleException() {}
	
	
	public SampleException(String errorMessage) {
		super(errorMessage);
	}


}
