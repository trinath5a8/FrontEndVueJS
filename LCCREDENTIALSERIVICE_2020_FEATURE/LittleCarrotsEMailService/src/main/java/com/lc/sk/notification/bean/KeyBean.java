/**
 * 
 */
package com.lc.sk.notification.bean;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsEMailService
 * 2020
 */
public class KeyBean {
	private String name;
	private String value;
	/**
	 * 
	 */
	public KeyBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param name
	 * @param value
	 */
	public KeyBean(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "KeyBean [name=" + name + ", value=" + value + "]";
	}
	
	
}
