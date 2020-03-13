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

import com.lc.sk.inventory.security.beans.ProductQuantities;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.rest.ProductquantitiesRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.INVENTORY_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
public class ProductquantitiesService {
	@Autowired
	ProductquantitiesRestService productquantitiesRestService;
	HttpHeaders header = new HttpHeaders();
	
	@GetMapping(URLMapping.PRODUCTQUANTITIES_GET_PATH)
	@ResponseBody
	public ResponseEntity<List<ProductQuantities>> getAllProductquantities()
	{
		List<ProductQuantities> productquantities = productquantitiesRestService.getAllProductQuantities();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<ProductQuantities>>(productquantities, header, HttpStatus.OK);
	}
	
	@GetMapping(URLMapping.PRODUCTQUANTITIES_GET_PATH_WITH_VARIABLE)
	@ResponseBody
	public ResponseEntity<ProductQuantities> getProductQuantitiesById(@PathVariable String custid)
	{
		ProductQuantities productquantities = productquantitiesRestService.getProductQuantitiesById(custid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ProductQuantities>(productquantities, header, HttpStatus.OK);
	}
	
	@PostMapping(URLMapping.PRODUCTQUANTITIES_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insert(
			
			@RequestParam(name = ConstantValues.QUANTITY, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String quantity,
			@RequestParam(name = ConstantValues.SIZE_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String sizeid
			
			)
	{
		ResponseBean responseBean = productquantitiesRestService.insertProductQuantities(quantity,sizeid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
	}
	
	@PutMapping(URLMapping.PRODUCTQUANTITIES_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> update(
			@RequestParam(name = ConstantValues.CUST_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String custid,
			@RequestParam(name = ConstantValues.QUANTITY, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String quantity,
			@RequestParam(name = ConstantValues.SIZE_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String sizeid
			)
	{
		ResponseBean responseBean = productquantitiesRestService.updateProductQuantities(custid, quantity, sizeid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
	}
}
