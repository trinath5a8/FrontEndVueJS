/**
 * 
 */
package com.lc.sk.auth.exceptions.subexceptions;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsAuthenticationService
 * 2020
 */
public class InvalidEmailFomatException extends RuntimeException {

	/**
	 * 
	 */
	public InvalidEmailFomatException() {
		super();
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public InvalidEmailFomatException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public InvalidEmailFomatException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 */
	public InvalidEmailFomatException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public InvalidEmailFomatException(Throwable arg0) {
		super(arg0);
	}

}
