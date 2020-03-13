package com.lc.sk.inventory.exception.subexception;

public class CategoriesException extends RuntimeException {

	private static final long serialVersionUID = -3983849902667377097L;

	public CategoriesException() {
		super();
	}

	public CategoriesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CategoriesException(String message, Throwable cause) {
		super(message, cause);
	}

	public CategoriesException(String message) {
		super(message);
	}

	public CategoriesException(Throwable cause) {
		super(cause);
	}

}
