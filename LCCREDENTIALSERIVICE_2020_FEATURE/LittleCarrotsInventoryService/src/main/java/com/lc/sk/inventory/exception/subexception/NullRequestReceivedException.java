/**
 * 
 */
package com.lc.sk.inventory.exception.subexception;

/**
 * @author Mastanvali Shaik LittleCarrotsInventoryService 2020
 */
public class NullRequestReceivedException extends RuntimeException {

	private static final long serialVersionUID = -9055412460297332467L;

	public NullRequestReceivedException() {
		super();
	}

	public NullRequestReceivedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

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
