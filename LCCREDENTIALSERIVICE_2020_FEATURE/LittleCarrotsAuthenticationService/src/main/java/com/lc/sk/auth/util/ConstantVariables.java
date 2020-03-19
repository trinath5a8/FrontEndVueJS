/**
 * 
 */
package com.lc.sk.auth.util;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsAuthenticationService
 * 2020
 */
public interface ConstantVariables {

	
	final static String AUTHORIZATION_ROLES_NOT_FOUND  = "Authorized Roles not Found...";
	final static String AUTHORIZATION_ROLE_NAME_VARIABLE_NAME = "rolename"; 
	final static String AUTHORIZATION_ROLE_DESCRIPTIONS_VARIABLE_NAME = "descriptions";
	final static String AUTHORIZATION_ROLE_STATUS_VARIABLE_NAME = "rolestatus";
	final static String DEFAULT_INT_VALUE = "0";
	final static String DEFAULT_STRING_VALUE = "noname";
	final static String DEFAULT_BOOLEAN = "false";
	
	final static String NULL_VALUES_RECEIVED_FROM_CLIENT = "Received Null Values from Client...";
	
	final static String NEW_AUTHORIZATION_ROLE_INSERTED_SUCCESS = "New Authorization Role Inserted Sucessfully....";
	final static String NEW_AUTHORIZATION_ROLE_INSERTED_FAILED = "New Authorization Role Inserted Failed....";
	
	final static String NO_AUTHORIZED_USER_FOUND = "No Authorized User Found....";
	
	final static String AUTHORIZED_USERNAME="username";
	final static String AUTHORIZED_PASSWORD = "password";
	final static String AUTHORIZED_NEW_PASSWORD = "newpassword";
	final static String AUTHORIZED_STATUS = "status";
	final static String AUTHORIZED_USER_EMAIL = "email";
	
	final static String NEW_AUTHORIZED_USER_INSERTED_SUCCESS = "New Authorized User Inserted Sucessfully....";
	final static String NEW_AUTHORIZED_USER_INSERTED_FAILED = "New Authorized User Inserted Failed....";
	
	final static String INVALID_USERNAME = "Invalid username/password...";
	final static int LAST_LOGIN_TIME=0;
	
	final static String PASSWORD_UPDATE_SUCCESS = "Password update sucess...";
	
	final static String NEW_PASSWORD_NOT_UPDATED = "New Password not updated, please try later...";
	
	final static String STATUS_CHANGE_SUCESS = "Status changed...";
	
	final static String STATUS_NOT_UPDATED_EXCEPTION_MSG = "Status not updated in Db..";
	
	final static String SELLER_ID = "sellerid";
	final static String SELLER_NAME = "sellername";
	final static String SELLER_COMPANY_NAME = "sellercompanyname";
	final static String PHONE_NUMBER ="phonenumber";
	final static String ADDRESS= "address";
	final static String EMAIL = "email";
	final static String ISOCODE="isocode";
	final static String STATUS = "status";
	
	final static String NEW_SELLER_INSERTED_SUCCESS = "New Seller Inserted Sucessfully....";
	final static String NEW_SELLER_INSERTED_FAILED = "New Seller Inserted Failed....";
	final static String SELLER_NOT_FOUND = "No Sellers Found....";
	
	final static String SELLER_UPDATE_SUCCESS = "New Seller updated Sucessfully....";
	final static String SELLER_UPDATE_FAILED = "New Seller updated Failed....";
	
	final static String FULLNAME = "fullname";
	
	
	final static String NEW_SALES_USER_INSERTED_SUCCESS = "New Sales User Inserted Sucessfully....";
	final static String NEW_SALES_USER_INSERTED_FAILED = "New Sales User Inserted Failed....";
	final static String SALES_USER_NOT_FOUND = "No Sales User Found....";
	
	final static String SELLER_STATUS_UPDATE_SUCCESS = "New Seller Status update Sucessfully....";
	final static String SELLER_STATUS_UPDATE_FAILED = "New Seller Status update Failed....";
	
	final static String BAD_CREDENTIALS= "The API key was not found " + "or not the expected value.";
	
	final static String NOT_ACCEPTABLE = "N/A";
	final static String NOT_VALID_EMAIL = "Not Valid Email address...";
	
	final static long HEADER_KEY_DB_ID_1 = 1000;
	static final String STATUS_NOT_UPDATED = " No user role found";
	static final String USER_NAME_NOT_FOUND = "User name not found";
	
	final static String EMAIL_API_ACCESS_KEY = "EMAIL_API_ACCESS_KEY";
	final static String ERROR_BEAN_RETURNED = "Returned Error Bean";
	final  static String MAIL_NOT_SENT = "Mail Server has issue and mail not sent to destination";
	final static String MAIL_SEND_STATUS = "EMAIL_SERVICE";
}
