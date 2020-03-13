/**
 * 
 */
package com.lc.sk.inventory.exception.subexception;

/**
 * @author Mastanvali Shaik LittleCarrotsInventoryService 2020
 */
public class CountriesNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 232560437846957833L;

	public CountriesNotFoundException() {
		super();
	}

	public CountriesNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CountriesNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CountriesNotFoundException(String arg0) {
		super(arg0);
	}

	public CountriesNotFoundException(Throwable arg0) {
		super(arg0);
	}

}
