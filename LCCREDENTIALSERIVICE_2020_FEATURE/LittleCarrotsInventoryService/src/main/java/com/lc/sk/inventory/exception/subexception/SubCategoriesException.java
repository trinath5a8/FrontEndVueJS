package com.lc.sk.inventory.exception.subexception;

public class SubCategoriesException extends RuntimeException {

	private static final long serialVersionUID = -2730188804764888569L;

	public SubCategoriesException() {
		super();
	}

	public SubCategoriesException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SubCategoriesException(String message, Throwable cause) {
		super(message, cause);
	}

	public SubCategoriesException(String message) {
		super(message);
	}

	public SubCategoriesException(Throwable cause) {
		super(cause);
	}

}
