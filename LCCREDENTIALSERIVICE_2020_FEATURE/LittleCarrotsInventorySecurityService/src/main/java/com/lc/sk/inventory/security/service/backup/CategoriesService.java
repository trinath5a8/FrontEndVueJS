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

import com.lc.sk.inventory.security.beans.Categories;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.rest.CategoriesRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.INVENTORY_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
public class CategoriesService {

	@Autowired
	CategoriesRestService categoriesRestService;
	HttpHeaders header = new HttpHeaders();
	
	@PostMapping(path = URLMapping.CATEGORIES_MAPPING_PATH)
	@ResponseBody	
	public ResponseEntity<ResponseBean> addList(
			@RequestParam(name = ConstantValues.CATEGORY, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String category,
			@RequestParam(name = ConstantValues.GENDER, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String gender
			) {
		ResponseBean responseBean = categoriesRestService.addCategory(category, gender);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.ACCEPTED);	
	}
	
	 @PutMapping(path = URLMapping.CATEGORIES_MAPPING_PATH)
	 @ResponseBody
	 public ResponseEntity<ResponseBean> update(
			@RequestParam(name = ConstantValues.CAT_ID, required = true) String catid,
			@RequestParam(name = ConstantValues.CATEGORY, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String category,
			@RequestParam(name = ConstantValues.GENDER, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String gender)
	 {
		 ResponseBean responseBean = categoriesRestService.update(catid,category,gender);
		 header.add("Server", "SecurityServiceInventory");
			return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.ACCEPTED);	
	 }
	 
	    @GetMapping(URLMapping.CATEGORIES_MAPPING_PATH_WITH_ID)
		@ResponseBody
		public ResponseEntity<Categories> getById(@PathVariable String catid)
		{
		 Categories categories = categoriesRestService.getById(catid);
			header.add("Server", "SecurityServiceInventory");
			return new ResponseEntity<Categories>(categories, header, HttpStatus.ACCEPTED);
		}
	 
	    @GetMapping(URLMapping.CATEGORIES_MAPPING_PATH)
		@ResponseBody
		public ResponseEntity<List<Categories>> getAllCategories()
		{
	    	List<Categories> categories = categoriesRestService.getAllCategories();
			header.add("Server", "SecurityServiceInventory");
			return new ResponseEntity<List<Categories>>(categories, header, HttpStatus.ACCEPTED);
		}
	    
}




