package br.com.abruno.client.exceptions;

import java.io.Serializable;

public class DataInvalidaException extends RuntimeException implements Serializable{

	private static final long serialVersionUID = 1L;

	public DataInvalidaException() {
		
	}
	
	public DataInvalidaException(String exception) {
		super(exception);
	}
	
	 public DataInvalidaException(String message, Throwable cause) {
	        super(message, cause);
	    }

	    public DataInvalidaException(Throwable cause) {
	        super(cause);
	    }

	    public DataInvalidaException(String message, Throwable cause, 
	         boolean enableSuppression, boolean writableStackTrace) {
	      super(message, cause, enableSuppression, writableStackTrace);
	    }
}
