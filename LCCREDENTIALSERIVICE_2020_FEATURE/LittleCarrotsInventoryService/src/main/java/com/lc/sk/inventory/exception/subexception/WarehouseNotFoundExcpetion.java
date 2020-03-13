/**
 * 
 */
package com.lc.sk.inventory.exception.subexception;

/**
 * @author Mastanvali Shaik LittleCarrotsInventoryService 2020
 */
public class WarehouseNotFoundExcpetion extends RuntimeException {

	private static final long serialVersionUID = 8232051520422630886L;

	public WarehouseNotFoundExcpetion() {
		super();
	}

	public WarehouseNotFoundExcpetion(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public WarehouseNotFoundExcpetion(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public WarehouseNotFoundExcpetion(String arg0) {
		super(arg0);
	}

	public WarehouseNotFoundExcpetion(Throwable arg0) {
		super(arg0);
	}

}
