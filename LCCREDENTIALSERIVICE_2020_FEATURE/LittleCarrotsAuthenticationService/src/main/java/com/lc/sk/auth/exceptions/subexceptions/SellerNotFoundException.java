/**
 * 
 */
package com.lc.sk.auth.exceptions.subexceptions;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsAuthenticationService
 * 2020
 */
public class SellerNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	public SellerNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public SellerNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SellerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public SellerNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public SellerNotFoundException(Throwable cause) {
		super(cause);
	}

}
