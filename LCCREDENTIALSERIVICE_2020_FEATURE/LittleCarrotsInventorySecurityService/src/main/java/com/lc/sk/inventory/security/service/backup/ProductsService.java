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

import com.lc.sk.inventory.security.beans.Products;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.rest.ProductsRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.INVENTORY_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
public class ProductsService {

	@Autowired
	ProductsRestService productsRestService;
	HttpHeaders header = new HttpHeaders();
	
	@PostMapping( URLMapping.PRODUCTS_MAPPING_PATH)
	@ResponseBody	
	public ResponseEntity<ResponseBean> insert(
			@RequestParam(name=ConstantValues.DESCRIPTION_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String descriptionid,
			@RequestParam(name=ConstantValues.BATCH_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String batchid,
			@RequestParam(name=ConstantValues.GENDER_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String genderid,
			@RequestParam(name=ConstantValues.CATEGORY_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String catid,
			@RequestParam(name=ConstantValues.SUBCATID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String subcatid,
			@RequestParam(name=ConstantValues.SEASON_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String seasonid,
			@RequestParam(name=ConstantValues.OCCASION_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String occasionid,
			@RequestParam(name=ConstantValues.AGE_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String ageid,
			@RequestParam(name=ConstantValues.MATERIAL_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String materialid,
			@RequestParam(name=ConstantValues.COLOR_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String colorid,
			@RequestParam(name=ConstantValues.CUSTOMER_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String custid,
			@RequestParam(name=ConstantValues.STATUS, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String status)
			{
		ResponseBean responseBean = productsRestService.insert(descriptionid, batchid,genderid,catid,subcatid,seasonid,occasionid,ageid,materialid,colorid,custid,status);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);	
}
	@PutMapping(URLMapping.PRODUCTS_MAPPING_PATH)
	@ResponseBody	
	public ResponseEntity<ResponseBean> updatesize(
			@RequestParam(name=ConstantValues.PRODUCT_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String productid,
			@RequestParam(name=ConstantValues.DESCRIPTION_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String descriptionid,
			@RequestParam(name=ConstantValues.BATCH_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String batchid,
			@RequestParam(name=ConstantValues.GENDER_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String genderid,
			@RequestParam(name=ConstantValues.CATEGORY_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String catid,
			@RequestParam(name=ConstantValues.SUBCATID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String subcatid,
			@RequestParam(name=ConstantValues.SEASON_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String seasonid,
			@RequestParam(name=ConstantValues.OCCASION_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String occasionid,
			@RequestParam(name=ConstantValues.AGE_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String ageid,
			@RequestParam(name=ConstantValues.MATERIAL_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String materialid,
			@RequestParam(name=ConstantValues.COLOR_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String colorid,
			@RequestParam(name=ConstantValues.CUSTOMER_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String custid,
			@RequestParam(name=ConstantValues.STATUS, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String status)
			{
		ResponseBean responseBean = productsRestService.update(productid, descriptionid, batchid, genderid, catid, subcatid, seasonid, occasionid, ageid, materialid, colorid, custid, status);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);	
	}
	
	@PutMapping( URLMapping.PRODUCTS_MAPPING_PATH_WITH_PATH_VARIABLE_1)
	@ResponseBody
	public ResponseEntity<ResponseBean> enableBatchStatus(@PathVariable String productid,@PathVariable String status)
	{
		ResponseBean response = productsRestService.enableBatchStatus(productid, status);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(response, header, HttpStatus.OK);
	}
	
	@GetMapping(URLMapping.PRODUCTS_MAPPING_PATH_ID)
	@ResponseBody
	public ResponseEntity<Products> getById(@PathVariable String productid)
	{
		Products products = productsRestService.getbyid(productid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<Products>(products, header, HttpStatus.OK);
	}
	
	
	@GetMapping(URLMapping.PRODUCTS_MAPPING_PATH)
	@ResponseBody
	public ResponseEntity<List<Products>> getall()
	{
		List<Products> products = productsRestService.getall();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<Products>>(products, header, HttpStatus.OK);
	}
	
}
