package com.lc.sk.inventory.exception.subexception;

public class ProductTypeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -77993708870982302L;

	public ProductTypeNotFoundException() {
		super();
	}

	public ProductTypeNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ProductTypeNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ProductTypeNotFoundException(String arg0) {
		super(arg0);
	}

	public ProductTypeNotFoundException(Throwable arg0) {
		super(arg0);
	}

	
}
