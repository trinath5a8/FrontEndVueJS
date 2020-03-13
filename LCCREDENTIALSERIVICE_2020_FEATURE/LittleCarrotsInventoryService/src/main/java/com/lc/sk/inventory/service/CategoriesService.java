package com.lc.sk.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.lc.sk.inventory.bean.ResponseBean;
import com.lc.sk.inventory.entities.Categories;
import com.lc.sk.inventory.exception.subexception.CategoriesException;
import com.lc.sk.inventory.exception.subexception.DBInsertException;
import com.lc.sk.inventory.repositories.CategoriesRepository;
import com.lc.sk.inventory.util.ConstantValues;
import com.lc.sk.inventory.util.HeaderComponent;
import com.lc.sk.inventory.util.SecurityHttpStatus;
import com.lc.sk.inventory.util.URLMapping;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(path = URLMapping.INVENTORY_ROOT_PATH)

public class CategoriesService {

	@Autowired
	CategoriesRepository categoriesRepository;
	
	@Autowired
	HeaderComponent hearders;
	
		
	public CategoriesService() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	/* Get all Categories list */
	@GetMapping(path = URLMapping.CATEGORIES_MAPPING_PATH)
	@ResponseBody
	public ResponseEntity<List<Categories>> getAllCategories() {
		List<Categories> categories = (List<Categories>) categoriesRepository.findAll();
		if (categories.isEmpty()) {
			throw new CategoriesException(ConstantValues.NO_CATEGORIES_LIST_FOUND);
		} else {

			return new ResponseEntity<List<Categories>>(categories, hearders.getHeader(), HttpStatus.ACCEPTED);
		}

	}

	/* categories details by catid */
	@GetMapping(path = URLMapping.CATEGORIES_MAPPING_PATH_BY_CID)
	@ResponseBody
	public ResponseEntity<Optional<Categories>> getById(@PathVariable long catid) {
		Optional<Categories> categories = categoriesRepository.findById(catid);
		if (!categories.isPresent()||categories.get() == null) {
			throw new CategoriesException(ConstantValues.NO_CATEGORIES_LIST_FOUND_GIVEN_CATID);
		} else {
			return new ResponseEntity<Optional<Categories>>(categories, hearders.getHeader(), HttpStatus.ACCEPTED);
		}
	}
	
	
	
	//insertion 
	@PostMapping(path = URLMapping.CATEGORIES_MAPPING_PATH)
	@ResponseBody	
	public ResponseEntity<ResponseBean> addList(
			@RequestParam(name = ConstantValues.CATEGORY, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String category,
			@RequestParam(name = ConstantValues.GENDER, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String gender
			) {
		ResponseBean responseBean = new ResponseBean();
		Categories categories=categoriesRepository.save(new Categories(category,gender));
		if( categories.getCategory().equals(category))
		{
			responseBean.setMessage(ConstantValues.DATA_INSERTED_IN_DB);
			responseBean.setResponsecode(SecurityHttpStatus.ACCEPTED);
			responseBean.setTiemstamp(System.currentTimeMillis());
			return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);
		}else {
			throw new DBInsertException(ConstantValues.DATA_NOT_INSERTED_IN_DB);
		}
		
	}
	
	

	/* Categories details update by id */
	@PutMapping(path = URLMapping.CATEGORIES_MAPPING_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> update(
			@RequestParam(name = ConstantValues.CATID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long catid,
			@RequestParam(name = ConstantValues.CATEGORY, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String category,
			@RequestParam(name = ConstantValues.GENDER, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String gender
			) 
	{
		Optional<Categories> categories = categoriesRepository.findById(catid);
		if (categories.isPresent()) {
			categories.get().setCategory(category);
			categories.get().setGender(gender);	
			Categories categories1 =categoriesRepository.save(categories.get());

			if (categories1.getCatid() == catid) {
				ResponseBean responseBean1 = new ResponseBean(ConstantValues.DATA_UPDATED_IN_DB,
						SecurityHttpStatus.ACCEPTED, System.currentTimeMillis());
				return new ResponseEntity<ResponseBean>(responseBean1, hearders.getHeader(), HttpStatus.ACCEPTED);
			} else {
				throw new DBInsertException(ConstantValues.DATA_NOT_UPDATED_IN_DB);
			}

		} else {
			throw new CategoriesException(ConstantValues.NO_CATEGORIES_LIST_FOUND_GIVEN_CATID);
		}
}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
