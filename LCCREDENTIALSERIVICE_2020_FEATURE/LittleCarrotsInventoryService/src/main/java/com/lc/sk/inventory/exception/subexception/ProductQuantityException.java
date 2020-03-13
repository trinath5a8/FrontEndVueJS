package com.lc.sk.inventory.exception.subexception;

public class ProductQuantityException extends RuntimeException {

	private static final long serialVersionUID = 4454631904883044619L;

	public ProductQuantityException() {
		super();
	}

	public ProductQuantityException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProductQuantityException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductQuantityException(String message) {
		super(message);
	}

	public ProductQuantityException(Throwable cause) {
		super(cause);
	}

}
