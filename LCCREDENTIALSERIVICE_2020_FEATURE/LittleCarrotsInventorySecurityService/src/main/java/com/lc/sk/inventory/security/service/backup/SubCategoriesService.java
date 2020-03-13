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

import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.beans.SubCategories;
import com.lc.sk.inventory.security.rest.SubCategoriesRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.INVENTORY_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
public class SubCategoriesService {

	@Autowired
	SubCategoriesRestService subcategoriesRestService;
	HttpHeaders header = new HttpHeaders();
	
	@GetMapping(URLMapping.SUBCATEGORIES_GET_PATH)
	@ResponseBody
	public ResponseEntity<List<SubCategories>> getAllSubCategoriesDetails()
	{
		List<SubCategories> subcategories = subcategoriesRestService.getAllSubCategoriesDetails();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<SubCategories>>(subcategories, header, HttpStatus.OK);
	}
	
	
	@GetMapping(URLMapping.SUBCATEGORIES_MAPPING_PATH_WITH_VARIABLE )
	@ResponseBody
	public ResponseEntity<SubCategories> getSubCategoriesById(@PathVariable String subcatid)
	{
		SubCategories subcategories = subcategoriesRestService.getSubCategoriesById(subcatid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<SubCategories>(subcategories, header, HttpStatus.OK);
	}
	
	@PostMapping(URLMapping.SUBCATEGORIES_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insert(
			@RequestParam(name = ConstantValues.CATID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String catid,
			@RequestParam(name = ConstantValues.CATEGORYNAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String categoryname
			)	
			
	{
		ResponseBean responseBean = subcategoriesRestService.insertSubcategorytype(catid, categoryname);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
	}
	
	@PutMapping(URLMapping.SUBCATEGORIES_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> update(
			@RequestParam(name = ConstantValues.SUBCATID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String subcatid,
			@RequestParam(name = ConstantValues.CATID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String catid,
			@RequestParam(name = ConstantValues.CATEGORYNAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String categoryname
			)
	{
		ResponseBean responseBean = subcategoriesRestService.updateSubcategorytype(subcatid, catid, categoryname);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
	}
}
	
	

