package com.lc.sk.inventory.exception.subexception;

public class SeasonWearNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 921223050016990734L;

	public SeasonWearNotFoundException() {
		super();
	}

	public SeasonWearNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public SeasonWearNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public SeasonWearNotFoundException(String arg0) {
		super(arg0);
	}

	public SeasonWearNotFoundException(Throwable arg0) {
		super(arg0);
	}

}
