/**
 * 
 */
package com.lc.sk.auth.exceptions;

//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lc.sk.auth.exceptions.subexceptions.AuthorizationNotFountException;
import com.lc.sk.auth.exceptions.subexceptions.AuthorizedUserNotFoundException;
import com.lc.sk.auth.exceptions.subexceptions.DBPasswordUpdateException;
import com.lc.sk.auth.exceptions.subexceptions.DBValueInsertException;
import com.lc.sk.auth.exceptions.subexceptions.EncDecException;
import com.lc.sk.auth.exceptions.subexceptions.InvalidEmailFomatException;
import com.lc.sk.auth.exceptions.subexceptions.NullRequestReceivedException;
import com.lc.sk.auth.exceptions.subexceptions.SellerNotFoundException;
import com.lc.sk.auth.exceptions.subexceptions.SellerUserNotFoundException;
import com.lc.sk.auth.rbeans.ResponseBean;
import com.lc.sk.auth.util.HeaderComponent;
import com.lc.sk.auth.util.SecurityHttpStatus;

/**
 * @author Mastanvali Shaik LittleCarrotsAuthenticationService 2020
 */

@ControllerAdvice
public class GlobalException {

	@Autowired
	HeaderComponent headers;
	
	static Logger log = LoggerFactory.getLogger(GlobalException.class);

	public GlobalException() {
		super();
		
	}

	/* Authorization Not Found Exception */
	@ExceptionHandler
	public ResponseEntity<ResponseBean> handleException(AuthorizationNotFountException e) {
		return loggerMessage("URL:/authorization---- handleException(AuthorizationNotFountException)-",e.getMessage(), SecurityHttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseBean> handleException(NullRequestReceivedException e) {
		return loggerMessage("URL:/authorization---- handleException(NullRequestReceivedException)-",e.getMessage(), SecurityHttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseBean> handleException(DBValueInsertException e) {
		return loggerMessage("URL:/authorization---- handleException(DBValueInsertException)-",e.getMessage(), SecurityHttpStatus.FAILED_DEPENDENCY);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseBean> handleException(AuthorizedUserNotFoundException e) {
		return loggerMessage("URL:/authroizedusers---- handleException(AuthorizedUserNotFoundException)-",e.getMessage(), SecurityHttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseBean> handleException(EncDecException e) {
		return loggerMessage("URL:/authroizedusers---- handleException(EncDecException)-",e.getMessage(), SecurityHttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseBean> handleException(InvalidEmailFomatException e) {
		return loggerMessage("URL:/authroizedusers---- handleException(InvalidEmailFomatException)-",e.getMessage(), SecurityHttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseBean> handleException(DBPasswordUpdateException e) {
		return loggerMessage("URL:/authroizedusers---- handleException(DBPasswordUpdateException)-",e.getMessage(), SecurityHttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseBean> handleException(SellerNotFoundException e) {
		return loggerMessage("URL:/sellers---- handleException(SellerNotFoundException)-",e.getMessage(), SecurityHttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseBean> handleException(SellerUserNotFoundException e) {
		return loggerMessage("URL:/salesuser---- handleException(SellerUserNotFoundException)-",e.getMessage(), SecurityHttpStatus.NOT_FOUND);
	}
	
//	@ExceptionHandler
//	public ResponseEntity<ResponseBean> handleException(ValueNotFoundException e) {
//		return loggerMessage("URL:/salesuser---- handleException(ValueNotFoundException)-",e.getMessage(), SecurityHttpStatus.NOT_FOUND);
//	}
	
	public ResponseEntity<ResponseBean> loggerMessage(String url, String message, int status)
	{
		ResponseBean seb = new ResponseBean();
		seb.setMessage(message);
		seb.setResponsecode(status);
		seb.setTiemstamp(System.currentTimeMillis());
		log.error(url+ seb.toString());
		return new ResponseEntity<ResponseBean>(seb, headers.getHeader(), HttpStatus.OK);
	}
}
