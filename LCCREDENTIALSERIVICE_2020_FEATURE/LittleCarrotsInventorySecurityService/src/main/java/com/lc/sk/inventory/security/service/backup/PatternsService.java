package com.lc.sk.inventory.security.service.backup;

import java.util.List;

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

import com.lc.sk.inventory.security.beans.Patterns;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.rest.PatternsRestService;
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
@RequestMapping(value = URLMapping.INVENTORY_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })

public class PatternsService {

	@Autowired
	PatternsRestService patternsRestService;
	HttpHeaders header = new HttpHeaders();
	
	@GetMapping(URLMapping.PATTERNS_PATH)
	@ResponseBody
	public ResponseEntity<List<Patterns>> getAllPatternsDetails()
	{
		List<Patterns>  patterns = patternsRestService.getAllPatternsDetails();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<Patterns>>( patterns, header, HttpStatus.OK);
	}
	
	
	@GetMapping(URLMapping.PATTERNS_PATH_WITH_ID)
	@ResponseBody
	public ResponseEntity<Patterns> getPatternsById(@PathVariable String patid)
	{
		Patterns  patterns = patternsRestService.getPatternsById(patid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<Patterns>( patterns, header, HttpStatus.OK);
	}
	
	
	
	@PostMapping(URLMapping.PATTERNS_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insert(
			@RequestParam(name = ConstantValues.DESCRIPTION, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String description,
			@RequestParam(name = ConstantValues.PRODUCTID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String productid
			)	
			
	{
		ResponseBean responseBean = patternsRestService.InsertPatternsDetails(description, productid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
	}
	
	@PutMapping(URLMapping.PATTERNS_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> update(
			@RequestParam(name = ConstantValues.PATID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String patid,
			@RequestParam(name = ConstantValues.DESCRIPTION, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String description,
			@RequestParam(name = ConstantValues.PRODUCTID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String productid
			)
	{
		ResponseBean responseBean = patternsRestService.UpdatePatternsDetails(patid, description, productid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
