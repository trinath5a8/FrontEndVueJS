/**
 * 
 */
package com.lc.sk.auth.exceptions.subexceptions;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsAuthenticationService
 * 2020
 */
public class AuthorizationNotFountException extends RuntimeException {
	public AuthorizationNotFountException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthorizationNotFountException(String message) {
		super(message);
	}

	public AuthorizationNotFountException(Throwable cause) {
		super(cause);
	}
}
