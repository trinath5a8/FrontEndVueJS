package com.lc.sk.inventory.exception.subexception;

public class PricesTableException extends RuntimeException {
	private static final long serialVersionUID = -6443698664603224307L;

	public PricesTableException() {
		super();
	}

	public PricesTableException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public PricesTableException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public PricesTableException(String arg0) {
		super(arg0);
	}

	public PricesTableException(Throwable arg0) {
		super(arg0);
	}

}
