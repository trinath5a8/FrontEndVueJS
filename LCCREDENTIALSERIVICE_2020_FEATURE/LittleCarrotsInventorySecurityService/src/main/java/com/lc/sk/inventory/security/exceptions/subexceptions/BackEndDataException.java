/**
 * 
 */
package com.lc.sk.inventory.security.exceptions.subexceptions;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsInventorySecurityService
 * 2020
 */
public class BackEndDataException extends RuntimeException {

	/**
	 * 
	 */
	public BackEndDataException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public BackEndDataException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BackEndDataException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public BackEndDataException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public BackEndDataException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
