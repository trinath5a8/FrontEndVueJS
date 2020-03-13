package com.lc.sk.inventory.exception.subexception;

public class ProductDescriptionsNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5868321960239183696L;

	public ProductDescriptionsNotFoundException() {
		super();
	}

	public ProductDescriptionsNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ProductDescriptionsNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ProductDescriptionsNotFoundException(String arg0) {
		super(arg0);
	}

	public ProductDescriptionsNotFoundException(Throwable arg0) {
		super(arg0);
	}

}
