package com.lc.sk.inventory.exception.subexception;

public class SizeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5419080206526960977L;

	public SizeNotFoundException() {
		super();
	}

	public SizeNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public SizeNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public SizeNotFoundException(String arg0) {
		super(arg0);
	}

	public SizeNotFoundException(Throwable arg0) {
		super(arg0);
	}

}
