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

import com.lc.sk.inventory.security.beans.ProductType;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.rest.ProductTypeRestService;
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

public class ProductTypeService {
	@Autowired
	ProductTypeRestService producttypeRestService;
	HttpHeaders header = new HttpHeaders();
	
	
	
	@GetMapping(URLMapping.PRODUCTTYPE_GET_PATH)
	@ResponseBody
	public ResponseEntity<List<ProductType>> getAllProductTypeDetails()
	{
		List<ProductType> producttype = producttypeRestService.getAllProductTypeDetails();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<ProductType>>(producttype, header, HttpStatus.OK);
	}
	
	
	@GetMapping(URLMapping.PRODUCTTYPE_PATH_WITH_ID)
	@ResponseBody
	public ResponseEntity<ProductType> getProductTypeById(@PathVariable String protypeid)
	{
		ProductType producttype = producttypeRestService.getProductTypeById(protypeid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ProductType>(producttype, header, HttpStatus.OK);
	}
	
	@PostMapping(URLMapping.PRODUCTTYPE_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insert(
			@RequestParam(name = ConstantValues.SUBCAT_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String subcatid,
			@RequestParam(name = ConstantValues.PRODUCTTYPE_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String producttypename
			)	
			
	{
		ResponseBean responseBean = producttypeRestService.InsertProductType(subcatid, producttypename);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
	}
	
	@PutMapping(URLMapping.PRODUCTTYPE_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> update(
			@RequestParam(name = ConstantValues.PROTYPE_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String protypeid,
			@RequestParam(name = ConstantValues.SUBCAT_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String subcatid,
			@RequestParam(name = ConstantValues.PRODUCTTYPE_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String producttypename
			)
	{
		ResponseBean responseBean = producttypeRestService.UpdateProductType(protypeid, subcatid, producttypename);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
	}
}

