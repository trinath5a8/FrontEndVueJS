/**
 * 
 */
package com.lc.sk.inventory.security.service.backup;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lc.sk.inventory.security.beans.AuthenticationBean;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.beans.SellerUsers;
import com.lc.sk.inventory.security.rest.SalesSellerRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsInventorySecurityService
 * 2020
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.SALLER_SELLER_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
public class SalesSellerService {

	HttpHeaders header = new HttpHeaders();
	
	@Autowired
	private SalesSellerRestService salesSellerRestService;
	
	@GetMapping(URLMapping.SALLER_SELLER_GET_PATH)
	@ResponseBody
	public ResponseEntity<List<SellerUsers>> getAllSalesUsers(HttpServletRequest request)
	{
		String rolename = (String) request.getSession().getAttribute(ConstantValues.SESSION_ROLENAME);
		System.out.println("Rolename:"+rolename);
		List<SellerUsers> salesUsers = salesSellerRestService.getAllSalesUsers();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<SellerUsers>>(salesUsers, header, HttpStatus.OK);
	}
	
	
	@GetMapping(URLMapping.SALES_SELLER_GET_PATH_WITH_VARIABLE)
	@ResponseBody
	public ResponseEntity<SellerUsers> getSalesUser(@PathVariable String username)
	{
		SellerUsers sallerUser = salesSellerRestService.getSalesUserByusername(username);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<SellerUsers>(sallerUser, header, HttpStatus.OK);
	}
	
	@PostMapping(URLMapping.INSERT_SALLER_SELLER_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insertNewSalesUser(
			@RequestParam(name = ConstantValues.AUTHORIZED_USERNAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String username,
			@RequestParam(name = ConstantValues.AUTHORIZED_PASSWORD, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String password,
			@RequestParam(name = ConstantValues.EMAIL, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String email,
			@RequestParam(name = ConstantValues.FULLNAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String fullname,
			@RequestParam(name = ConstantValues.AUTHORIZATION_ROLE_NAME_VARIABLE_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String rolename,
			@RequestParam(name = ConstantValues.SELLER_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT_VALUE) String sellerid,
			@RequestParam(name = ConstantValues.STATUS, required = true, defaultValue = ConstantValues.DEFAULT_INT_VALUE) boolean status)

	{
		ResponseBean responseBean  = salesSellerRestService.insertNewSalesUser(username, password, email, fullname, rolename, sellerid, status);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
		
	}
	
	
	@PostMapping(URLMapping.SALLER_SALLER_LOGIN_PATH)
	@ResponseBody
	public ResponseEntity<AuthenticationBean> login(
			@RequestParam(name = ConstantValues.AUTHORIZED_USERNAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String username,
			@RequestParam(name = ConstantValues.AUTHORIZED_PASSWORD, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String password,
			HttpSession session)
	{
		AuthenticationBean responseBean  = salesSellerRestService.selesUserLogin(username, password);
		session.setAttribute(ConstantValues.SESSION_USERNAME, responseBean.getUsername());
		session.setAttribute(ConstantValues.SESSION_EMAIL, responseBean.getEmail());
		session.setAttribute(ConstantValues.SESSION_ROLENAME, responseBean.getRolename());
		session.setAttribute(ConstantValues.SESSION_TOKENID, responseBean.getTokenid());
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<AuthenticationBean>(responseBean, header, HttpStatus.OK);
		
	}
	
	@PutMapping(URLMapping.SALLER_SALLER_PUT_STATUS)
	@ResponseBody
	public ResponseEntity<ResponseBean> updateStatus(@PathVariable String username, @PathVariable String status)
	{
		ResponseBean responseBean  = salesSellerRestService.updateSalesUserStatus(username, status);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
		
	}
	
	@PutMapping(URLMapping.SALLER_SELLER_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> updateStatus(
			@RequestParam(name = ConstantValues.AUTHORIZED_USERNAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String username,
			@RequestParam(name = ConstantValues.AUTHORIZED_PASSWORD, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String password,
			@RequestParam(name = ConstantValues.AUTHORIZED_NEW_PASSWORD, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String newpassword	
			)
	{
		ResponseBean responseBean  = salesSellerRestService.updateSalesUserPasswrod(username, password, newpassword);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
		
	}
	
	
	
	
}
