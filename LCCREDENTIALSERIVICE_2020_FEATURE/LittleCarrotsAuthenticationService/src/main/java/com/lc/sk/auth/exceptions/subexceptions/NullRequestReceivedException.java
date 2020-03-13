/**
 * 
 */
package com.lc.sk.auth.exceptions.subexceptions;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsAuthenticationService
 * 2020
 */
public class NullRequestReceivedException extends RuntimeException {
	public NullRequestReceivedException(String message, Throwable cause) {
		super(message, cause);
	}

	public NullRequestReceivedException(String message) {
		super(message);
	}

	public NullRequestReceivedException(Throwable cause) {
		super(cause);
	}
}
