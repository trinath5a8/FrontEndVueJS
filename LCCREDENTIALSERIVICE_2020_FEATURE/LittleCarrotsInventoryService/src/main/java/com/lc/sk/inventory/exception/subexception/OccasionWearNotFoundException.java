package com.lc.sk.inventory.exception.subexception;

public class OccasionWearNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -7372517209762191061L;

	public OccasionWearNotFoundException() {
		super();
	}

	public OccasionWearNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public OccasionWearNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public OccasionWearNotFoundException(String arg0) {
		super(arg0);
	}

	public OccasionWearNotFoundException(Throwable arg0) {
		super(arg0);
	}

}
