package com.lc.sk.inventory.exception.subexception;

public class OccasionidNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -4559968839686531257L;

	public OccasionidNotFoundException() {
		super();
	}

	public OccasionidNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public OccasionidNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public OccasionidNotFoundException(String arg0) {
		super(arg0);
	}

	public OccasionidNotFoundException(Throwable arg0) {
		super(arg0);
	}
}
