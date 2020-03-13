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
import com.lc.sk.inventory.entities.SubCategories;
import com.lc.sk.inventory.exception.subexception.CategoriesException;
import com.lc.sk.inventory.exception.subexception.DBInsertException;
import com.lc.sk.inventory.exception.subexception.SubCategoriesException;
import com.lc.sk.inventory.repositories.SubCategoriesRepository;
import com.lc.sk.inventory.util.ConstantValues;
import com.lc.sk.inventory.util.HeaderComponent;
import com.lc.sk.inventory.util.SecurityHttpStatus;
import com.lc.sk.inventory.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(path = URLMapping.INVENTORY_ROOT_PATH)
public class SubCategoriesService {

	@Autowired
	SubCategoriesRepository subcategoriesRepository;

	@Autowired
	HeaderComponent hearders;

	public SubCategoriesService() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	/* Get all SubCategories list */
	@GetMapping(path = URLMapping.SUBCATEGORIES_MAPPING_PATH)
	@ResponseBody
	public ResponseEntity<List<SubCategories>> getAllSubCategoriesDetails() {
		List<SubCategories> subcategories = (List<SubCategories>) subcategoriesRepository.findAll();
		if (subcategories.isEmpty()) {
			throw new SubCategoriesException(ConstantValues.NO_SUBCATEGORIES_LIST_FOUND);
		} else {
			return new ResponseEntity<List<SubCategories>>(subcategories, hearders.getHeader(), HttpStatus.ACCEPTED);
		}
	}

	/* Get all SubCategories list by id */
	@GetMapping(path = URLMapping.SUBCATEGORIES_MAPPING_PATH_WITH_ID)
	@ResponseBody
	public ResponseEntity<Optional<SubCategories>> getById(@PathVariable long subcatid) {
		Optional<SubCategories> subcategories = subcategoriesRepository.findById(subcatid);
		if (!subcategories.isPresent()||subcategories.get() == null) {
			throw new SubCategoriesException(ConstantValues.NO_SUBCATEGORIES_LIST_FOUND_GIVEN_SUBCATID);
		} else {
			return new ResponseEntity<Optional<SubCategories>>(subcategories, hearders.getHeader(),
					HttpStatus.ACCEPTED);
		}
	}

	
	
	/* SubCategories details  insertion */
		@PostMapping(path = URLMapping.SUBCATEGORIES_MAPPING_PATH)
		@ResponseBody
		public ResponseEntity<ResponseBean> addList(
				@RequestParam(name = ConstantValues.CATID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long catid,
				@RequestParam(name = ConstantValues.CATEGORYNAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String categoryname) {
			ResponseBean responseBean = new ResponseBean();
			SubCategories subcategories = subcategoriesRepository.save(new SubCategories(catid, categoryname));
			if (subcategories.getCategoryname().equals(categoryname)) {
				responseBean.setMessage(ConstantValues.DATA_INSERTED_IN_DB);
				responseBean.setResponsecode(SecurityHttpStatus.ACCEPTED);
				responseBean.setTiemstamp(System.currentTimeMillis());
				return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);
			} else {
				throw new DBInsertException(ConstantValues.DATA_NOT_INSERTED_IN_DB);
			}

		}
		
	
	
		/* SubCategories details update */
		@PutMapping(path = URLMapping.SUBCATEGORIES_MAPPING_PATH)
		@ResponseBody
		public ResponseEntity<ResponseBean> update(
				@RequestParam(name = ConstantValues.SUBCATID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long subcatid,
				@RequestParam(name = ConstantValues.CATID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long catid,
				@RequestParam(name = ConstantValues.CATEGORYNAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String categoryname) {
			Optional<SubCategories> subcategories = subcategoriesRepository.findById(subcatid);
			if (subcategories.isPresent()) {
				subcategories.get().setCatid(catid);
				subcategories.get().setCategoryname(categoryname);
				SubCategories subcategories1 = subcategoriesRepository.save(subcategories.get());

				if (subcategories1.getSubcatid() == subcatid) {
					ResponseBean responseBean1 = new ResponseBean(ConstantValues.DATA_UPDATED_IN_DB,
							SecurityHttpStatus.ACCEPTED, System.currentTimeMillis());
					return new ResponseEntity<ResponseBean>(responseBean1, hearders.getHeader(), HttpStatus.ACCEPTED);
				} else {
					throw new DBInsertException(ConstantValues.DATA_NOT_UPDATED_IN_DB);
				}

			} else {
				throw new CategoriesException(ConstantValues.NO_SUBCATEGORIES_LIST_FOUND_GIVEN_SUBCATID);
			}
	}
	}
