package com.lc.sk.inventory.exception.subexception;

public class ProductAgeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -6324955029678829263L;

	public ProductAgeNotFoundException() {
		super();
	}

	public ProductAgeNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ProductAgeNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ProductAgeNotFoundException(String arg0) {
		super(arg0);
	}

	public ProductAgeNotFoundException(Throwable arg0) {
		super(arg0);
	}

}
