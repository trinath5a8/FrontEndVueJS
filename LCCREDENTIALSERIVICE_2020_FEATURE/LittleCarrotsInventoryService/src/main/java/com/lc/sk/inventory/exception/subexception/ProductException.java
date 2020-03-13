package com.lc.sk.inventory.exception.subexception;

public class ProductException extends RuntimeException {

	private static final long serialVersionUID = 8371183964879027654L;

	public ProductException() {
		super();
	}

	public ProductException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ProductException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ProductException(String arg0) {
		super(arg0);
	}

	public ProductException(Throwable arg0) {
		super(arg0);
	}

}
