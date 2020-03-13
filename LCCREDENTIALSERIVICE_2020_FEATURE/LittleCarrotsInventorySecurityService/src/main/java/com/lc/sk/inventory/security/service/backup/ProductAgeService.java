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

import com.lc.sk.inventory.security.beans.ProductAge;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.rest.ProductAgeRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.INVENTORY_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
public class ProductAgeService {

	@Autowired
	
	
	ProductAgeRestService   productAgeRestService;
	
	HttpHeaders header = new HttpHeaders();
	
	@PostMapping(URLMapping.PRODUCTAGE_PATH)
	@ResponseBody
	
	
	public ResponseEntity<ResponseBean> addProductAge(
			@RequestParam(name = ConstantValues.AGE_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String ageid,
			@RequestParam(name = ConstantValues.DES, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String des
			
			)
	{
		ResponseBean responseBean = productAgeRestService.addProductAge(ageid,des);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
	}
	
	@GetMapping(URLMapping.PRODUCTAGE_PATH)
	@ResponseBody
	public ResponseEntity<List<ProductAge>> getAll(
			)
	{
		List<ProductAge> responseBean = productAgeRestService.getAll();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<ProductAge>>(responseBean, header, HttpStatus.OK);
	}
	
	@GetMapping(URLMapping.PRODUCTAGE_PATH_WITH_ID)
	@ResponseBody
	public ResponseEntity<ProductAge> getProductAgeById(@PathVariable String ageid)
			
	{
		ProductAge responseBean = productAgeRestService.getProductAgeById(ageid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ProductAge>(responseBean, header, HttpStatus.OK);
	}
	
	
	
	@PutMapping(URLMapping.PRODUCTAGE_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> update(
			@RequestParam(name = ConstantValues.AGE_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String ageid,
			@RequestParam(name = ConstantValues.DES, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String des
			
			
			)
	{
		ResponseBean responseBean = productAgeRestService.update(ageid,des);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
