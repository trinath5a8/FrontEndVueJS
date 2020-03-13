/**
 * 
 */
package com.lc.sk.auth.exceptions.subexceptions;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsAuthenticationService
 * 2020
 */
public class DBPasswordUpdateException extends RuntimeException {

	/**
	 * 
	 */
	public DBPasswordUpdateException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DBPasswordUpdateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DBPasswordUpdateException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public DBPasswordUpdateException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public DBPasswordUpdateException(Throwable cause) {
		super(cause);
	}

}
