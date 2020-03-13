/**
 * 
 */
package com.lc.sk.inventory.security.exceptions.subexceptions;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsInventorySecurityService
 * 2020
 */
public class RestURLReaderException extends RuntimeException{

	public RestURLReaderException() {
		super();
	}

	public RestURLReaderException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RestURLReaderException(String message, Throwable cause) {
		super(message, cause);
	}

	public RestURLReaderException(String message) {
		super(message);
	}

	public RestURLReaderException(Throwable cause) {
		super(cause);
	}

	
}
