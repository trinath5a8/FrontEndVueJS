package com.lc.sk.inventory.exception.subexception;

public class NoOfPiecesNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3094681780828727634L;

	public NoOfPiecesNotFoundException() {
		super();
	}

	public NoOfPiecesNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public NoOfPiecesNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoOfPiecesNotFoundException(String arg0) {
		super(arg0);
	}

	public NoOfPiecesNotFoundException(Throwable arg0) {
		super(arg0);
	}

}
