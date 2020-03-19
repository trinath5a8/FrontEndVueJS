/**
 * 
 */
package com.lc.sk.auth.bean;


/**
 * @author Mastanvali Shaik
 * LittleCarrotsAuthenticationService
 * 2020
 */
public class ErrorBean  extends UrlBean {
	public ErrorBean(String ipaddress, String url, String get, long timeout, String servicename) {
		super(ipaddress, url, get, timeout, servicename);
	}
}
