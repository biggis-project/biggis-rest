package de.fzi.biggis.exceptions;

import java.io.Serializable;

public class ParameterException extends Exception implements Serializable{
	private static final long serialVersionUID = -6481494193288704432L;
	

	public ParameterException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParameterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ParameterException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ParameterException(String message) {
		super(message);
		System.out.println("New ParameterException created: " + message);
		// TODO Auto-generated constructor stub
	}

	public ParameterException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
