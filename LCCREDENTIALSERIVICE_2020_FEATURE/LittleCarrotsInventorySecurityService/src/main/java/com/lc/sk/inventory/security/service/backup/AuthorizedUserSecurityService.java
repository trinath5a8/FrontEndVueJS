/**
 * 
 */
package com.lc.sk.inventory.security.service.backup;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.lc.sk.inventory.security.beans.AuthenticationBean;
import com.lc.sk.inventory.security.beans.AuthorizedUsers;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.rest.AuthorizedUsersRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsInventorySecurityService
 * 2020
 */

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.AUTH_USER_ROOT_PATH )
public class AuthorizedUserSecurityService {

	HttpHeaders header = new HttpHeaders();
	
	@Autowired
	private AuthorizedUsersRestService authorizedUsersRestService;
	
	
	@GetMapping(URLMapping.AUTH_USER_GET_PATH)
	@ResponseBody
	public ResponseEntity<List<AuthorizedUsers>> getAllUsersList()
	{
		List<AuthorizedUsers> authorizedUsers = authorizedUsersRestService.getAllAuthorizedUsers();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<AuthorizedUsers>>(authorizedUsers, header, HttpStatus.OK);
	}
	
	
	@GetMapping(URLMapping.AUTH_USER_GET_WITH_PATH_VARIABLE)
	@ResponseBody
	public ResponseEntity<AuthorizedUsers> getUserByusername(@PathVariable String username)
	{
		AuthorizedUsers authorizedUser = authorizedUsersRestService.getAuthorizedUserByUsername(username);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<AuthorizedUsers>(authorizedUser, header, HttpStatus.OK);
	}
	
	@PostMapping(URLMapping.AUTH_USER_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insertUser(
			@RequestParam(name = ConstantValues.AUTHORIZED_USERNAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String username,
			@RequestParam(name = ConstantValues.AUTHORIZED_PASSWORD, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String password,
			@RequestParam(name = ConstantValues.AUTHORIZED_USER_EMAIL, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String email,
			@RequestParam(name = ConstantValues.AUTHORIZED_STATUS, required = true, defaultValue = ConstantValues.DEFAULT_INT_VALUE) boolean status,
			@RequestParam(name = ConstantValues.AUTHORIZATION_ROLE_NAME_VARIABLE_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String rolename
			)
	{
		ResponseBean responseBean = authorizedUsersRestService.insertNewUser(username, password, email, status, rolename);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
	}
	
	@PostMapping(URLMapping.AUTH_USER_LOGIN_PATH)
	@ResponseBody
	public ResponseEntity<AuthenticationBean> login(@RequestParam(name = ConstantValues.AUTHORIZED_USERNAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String username,
	@RequestParam(name = ConstantValues.AUTHORIZED_PASSWORD, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String password,
	HttpSession session)
	{
		System.err.println("Request set... called..");
		AuthenticationBean authenticationBean = authorizedUsersRestService.loginCheck(username, password);
		session.setAttribute(ConstantValues.SESSION_USERNAME, authenticationBean.getUsername());
		session.setAttribute(ConstantValues.SESSION_EMAIL, authenticationBean.getEmail());
		session.setAttribute(ConstantValues.SESSION_ROLENAME, authenticationBean.getRolename());
		session.setAttribute(ConstantValues.SESSION_TOKENID, authenticationBean.getTokenid());
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<AuthenticationBean>(authenticationBean, header, HttpStatus.OK);
	}
	
	@PutMapping(URLMapping.AUTH_USER_BLOCK)
	@ResponseBody
	public ResponseEntity<ResponseBean> blockUser(@PathVariable String username, @PathVariable boolean status)
	{
		ResponseBean responseBean = authorizedUsersRestService.blockUser(username, status);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
	}
	

}
