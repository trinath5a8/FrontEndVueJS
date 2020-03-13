/**
 * 
 */
package com.lc.sk.auth.exceptions.subexceptions;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsAuthenticationService
 * 2020
 */
public class DBValueInsertException extends RuntimeException{
	public DBValueInsertException(String message, Throwable cause) {
		super(message, cause);
	}

	public DBValueInsertException(String message) {
		super(message);
	}

	public DBValueInsertException(Throwable cause) {
		super(cause);
	}
}
