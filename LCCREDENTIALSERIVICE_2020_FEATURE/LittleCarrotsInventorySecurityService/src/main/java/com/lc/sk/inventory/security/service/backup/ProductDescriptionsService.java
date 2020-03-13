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

import com.lc.sk.inventory.security.beans.ProductDescriptions;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.rest.ProductDescriptionsRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.INVENTORY_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
public class ProductDescriptionsService {
	
	@Autowired
	ProductDescriptionsRestService productDescriptionsRestService;
	HttpHeaders header = new HttpHeaders();
	
	@PostMapping(path = URLMapping.PRODUCTDESCRIPTION_MAPPING_PATH)
	@ResponseBody	
	public ResponseEntity<ResponseBean> insertion(
			@RequestParam(name = ConstantValues.DESCRIPTION, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String description)
	{
		ResponseBean responseBean = productDescriptionsRestService.insert(description);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);	
	}
	
	 @PutMapping(path = URLMapping.PRODUCTDESCRIPTION_MAPPING_PATH)
	 @ResponseBody
	 public ResponseEntity<ResponseBean> update(
			@RequestParam(name = ConstantValues.DESCRIPTION_ID, required = true) String descriptionid,
			@RequestParam(name = ConstantValues.DESCRIPTION, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String description)
	 {
		 ResponseBean responseBean = productDescriptionsRestService.update(descriptionid,description);
		 header.add("Server", "SecurityServiceInventory");
			return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);	
	 }
	
	 	@GetMapping(URLMapping.PRODUCTDESCRIPTION_MAPPING_PATH_WITH_ID)
		@ResponseBody
		public ResponseEntity<ProductDescriptions> getById(@PathVariable String descriptionid)
		{
	 		ProductDescriptions productDescriptions = productDescriptionsRestService.getById(descriptionid);
			header.add("Server", "SecurityServiceInventory");
			return new ResponseEntity<ProductDescriptions>(productDescriptions, header, HttpStatus.OK);
		}
	 	
	 	@GetMapping(URLMapping.PRODUCTDESCRIPTION_MAPPING_PATH)
		@ResponseBody
		public ResponseEntity<List<ProductDescriptions>> getAllProductDescriptions()
		{
	    	List<ProductDescriptions> productDescriptions = productDescriptionsRestService.getAllProductDescriptions();
			header.add("Server", "SecurityServiceInventory");
			return new ResponseEntity<List<ProductDescriptions>>(productDescriptions, header, HttpStatus.OK);
		}

}
