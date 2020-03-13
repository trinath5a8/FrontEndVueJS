/**
 * 
 */
package com.lc.sk.auth.util;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsAuthenticationService
 * 2020
 */
public interface URLMapping {

	final static String AUTHORIZATION_ROOT_PATH = "/";
	final static String AUTHORIZATION_MAPPING_PATH="/authorization";
	final static String AUTHORIZATION_MAPPING_WITH_PATH_VARIABLE = "/authorization/{rolename}";
	final static String AUTHORIZATION_MAPPING_PATH_UPDATE_STATUS="/authorization/{rolename}/{status}";
	
	final static String AUTHORIZED_USER_MAPPING_PATH = "/authorizeduser";
	final static String AUTHORIZED_USER_MAPPING_WITH_PATH_VARIABLE = "/authorizeduser/{username}";
	final static String AUTHORIZED_USER_LOGIN_PATH="/authuserlogin";
	final static String AUTHORIZED_USER_STATUS_UPDATE = "/authorizeduser/{username}/{status}";
	
	final static String SELLER_MAPPING_PATH="/sellers";
	final static String SELLER_MAPPING_PATH_PATH_VARIABLE="/sellers/{sellerid}";
	final static String SELLER_UPDATE_MAPPING_PATH="/updatesellers";
	
	final static String SELLER_USER_MAPPING_PATH="/salesusers";
	final static String SELLER_USER_MAPPING_PATH_WITH_PATH_VARIABLE="/salesusers/{username}";
	final static String SELLER_USER_LOGIN_MAPPING_PATH="/salesuserslogin";
	final static String SELLER_USER_UPDATE_STATUS_MAPPING_PATH="/salesusers/{username}/{status}";
	
	final static String ROOT_PATH_FOR_VALIDATION = "/**";
}
