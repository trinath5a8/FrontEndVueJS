/**
 * 
 */
package com.lc.sk.inventory.security.service.backup;

import java.util.List;

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

import com.lc.sk.inventory.security.beans.Authorization;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.rest.AuthorizationRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;

/**
 * @author Mastanvali Shaik LittleCarrotsInventorySecurityService 2020
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.ADMIN_ROOT_PATH+URLMapping.AUTHORIZATION_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
public class AuthorizationSecurityService {


	HttpHeaders header  = new HttpHeaders();

	@Autowired
	private AuthorizationRestService authorizationRestService;

	@GetMapping(URLMapping.PATH_1)
	@ResponseBody
	public ResponseEntity<List<Authorization>> method1(HttpSession session) {
		System.out.println("SESSION ID: " + session.getId() + " Admin");
		List<Authorization> authroizations = authorizationRestService.getAllRoleList();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<Authorization>>(authroizations, header, HttpStatus.OK);
	}

	@GetMapping(URLMapping.PATH_2)
	@ResponseBody
	public ResponseEntity<Authorization> method2(HttpSession session, @PathVariable String rolename) {
		System.out.println("SESSION ID: " + session.getId() + " Admin");
		Authorization authroizations = authorizationRestService.getRoleByName(rolename);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<Authorization>(authroizations, header, HttpStatus.OK);
	}

	@PostMapping(URLMapping.PATH_1) // CODE FOR POST METHOD
	@ResponseBody
	public ResponseEntity<ResponseBean> insertData(
			@RequestParam(name = ConstantValues.AUTHORIZATION_ROLE_NAME_VARIABLE_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String rolename,
			@RequestParam(name = ConstantValues.AUTHORIZATION_ROLE_DESCRIPTIONS_VARIABLE_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String descriptions,
			@RequestParam(name = ConstantValues.AUTHORIZATION_ROLE_STATUS_VARIABLE_NAME, required = true, defaultValue = ConstantValues.DEFAULT_INT_VALUE) boolean authorization_status)

	{
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(
				authorizationRestService.insertAuthorization(rolename, descriptions, authorization_status), header,
				HttpStatus.OK);
	}
	
	@PutMapping(URLMapping.PATH_3) //CODE FOR PUT
	@ResponseBody
	public ResponseEntity<ResponseBean> updateStatus(HttpSession session,@PathVariable String rolename, @PathVariable boolean status)
	{
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(
				authorizationRestService.updateAuthorizationStatus(rolename, status), header,HttpStatus.OK);
	}
}
