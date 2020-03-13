package com.lc.sk.inventory.exception.subexception;

public class GendersException extends RuntimeException {

	private static final long serialVersionUID = -3350093918364788560L;

	public GendersException() {
		super();
	}

	public GendersException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public GendersException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public GendersException(String arg0) {
		super(arg0);
	}

	public GendersException(Throwable arg0) {
		super(arg0);
	}

}
