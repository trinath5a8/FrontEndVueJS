package com.lc.sk.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lc.sk.inventory.bean.ResponseBean;
import com.lc.sk.inventory.entities.Products;
import com.lc.sk.inventory.exception.subexception.BatchException;
import com.lc.sk.inventory.exception.subexception.DBDataNotUpdatedException;
import com.lc.sk.inventory.exception.subexception.DBInsertException;

import com.lc.sk.inventory.exception.subexception.NullRequestReceivedException;
import com.lc.sk.inventory.exception.subexception.ProductException;
import com.lc.sk.inventory.repositories.ProductsRepository;
import com.lc.sk.inventory.util.ConstantValues;
import com.lc.sk.inventory.util.HeaderComponent;
import com.lc.sk.inventory.util.URLMapping;

@RestController
@Validated
@RequestMapping(path = URLMapping.INVENTORY_ROOT_PATH)

public class ProductsService {
	@Autowired
	ProductsRepository productsrepository;

	@Autowired
	HeaderComponent hearders;

	public ProductsService() {

	}

	@GetMapping(path = URLMapping.PRODUCTS_MAPPING_PATH)
	@ResponseBody
	public ResponseEntity<List<Products>> getallProducts() {
		List<Products> products = (List<Products>) productsrepository.findAll();
		if (products.isEmpty()) {
			throw new ProductException(ConstantValues.NO_PRODUCTS_FOUND);

		} else {
			return new ResponseEntity<List<Products>>(products, hearders.getHeader(), HttpStatus.ACCEPTED);
		}
	}

	// Get by id
	@GetMapping(path = URLMapping.PRODUCTS_MAPPING_PATH_ID)
	@ResponseBody
	public ResponseEntity<Optional<Products>> getProductId(@PathVariable Long productid) {
		Optional<Products> products = productsrepository.findById(productid);
		if (products.isPresent()) {
			return new ResponseEntity<Optional<Products>>(products, hearders.getHeader(), HttpStatus.ACCEPTED);
		} else {
			throw new ProductException(ConstantValues.NO_PRODUCTS_FOUND);
		}
	}

	@PostMapping(path = URLMapping.PRODUCTS_MAPPING_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> addList(

			@RequestParam(name = ConstantValues.DESCRIPTION_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long descriptionid,
			@RequestParam(name = ConstantValues.BATCH_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long batchid,
			@RequestParam(name = ConstantValues.GENDER_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String genderid,
			@RequestParam(name = ConstantValues.CATEGORY_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long catid,
			@RequestParam(name = ConstantValues.SUBCATID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long subcatid,
			@RequestParam(name = ConstantValues.SEASON_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long seasonid,
			@RequestParam(name = ConstantValues.OCCASION_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) int occasionid,
			@RequestParam(name = ConstantValues.AGE_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String ageid,
			@RequestParam(name = ConstantValues.MATERIAL_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long materialid,
			@RequestParam(name = ConstantValues.COLOR_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long colorid,
			@RequestParam(name = ConstantValues.CUSTOMER_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long custid,
			@RequestParam(name = ConstantValues.STATUS, required = true, defaultValue = ConstantValues.DEFAULT_BOOLEAN + "") boolean status) {
		ResponseBean responseBean = new ResponseBean();

		if (descriptionid == new Long(ConstantValues.DEFAULT_INT).longValue()
				|| batchid == new Long(ConstantValues.DEFAULT_INT).longValue()
				|| genderid.equals(ConstantValues.DEFAULT_STRING)
				|| catid == new Long(ConstantValues.DEFAULT_INT).longValue()
				|| subcatid == new Long(ConstantValues.DEFAULT_INT).longValue()
				|| seasonid == new Long(ConstantValues.DEFAULT_INT).longValue()
				|| occasionid == new Long(ConstantValues.DEFAULT_INT).longValue()
				|| ageid.equals(ConstantValues.DEFAULT_STRING)
				|| materialid == new Long(ConstantValues.DEFAULT_INT).longValue()
				|| colorid == new Long(ConstantValues.DEFAULT_INT).longValue()
				|| custid == new Long(ConstantValues.DEFAULT_INT).longValue())
				//|| status.equals(ConstantValues.DEFAULT_BOOLEAN + "")
		{
			throw new NullRequestReceivedException(ConstantValues.RECEIVED_NULL_VALUES);
		} else {

			Products products = new Products(descriptionid, batchid, genderid, catid, subcatid, seasonid, occasionid,
					ageid, materialid, colorid, custid, status);
			products = productsrepository.save(products);
			if (products.getDescriptionid() == (descriptionid)) {
				responseBean.setMessage(ConstantValues.PRODUCTS_INSERTION_SUCCESS);
				responseBean.setResponsecode(HttpStatus.ACCEPTED.value());
				responseBean.setTiemstamp(System.currentTimeMillis());
				return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);
			} else {
				throw new DBInsertException(ConstantValues.PRODUCTS_INSERTION_HAS_ISSUE);
			}

		}

	}

	@PutMapping(path = URLMapping.PRODUCTS_MAPPING_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> update(
			@RequestParam(name = ConstantValues.PRODUCT_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long productid,
			@RequestParam(name = ConstantValues.DESCRIPTION_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long descriptionid,
			@RequestParam(name = ConstantValues.BATCH_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long batchid,
			@RequestParam(name = ConstantValues.GENDER_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String genderid,
			@RequestParam(name = ConstantValues.CATEGORY_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long catid,
			@RequestParam(name = ConstantValues.SUBCATID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long subcatid,
			@RequestParam(name = ConstantValues.SEASON_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long seasonid,
			@RequestParam(name = ConstantValues.OCCASION_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) int occasionid,
			@RequestParam(name = ConstantValues.AGE_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String ageid,
			@RequestParam(name = ConstantValues.MATERIAL_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long materialid,
			@RequestParam(name = ConstantValues.COLOR_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long colorid,
			@RequestParam(name = ConstantValues.CUSTOMER_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long custid,
			@RequestParam(name = ConstantValues.STATUS, required = true, defaultValue = ConstantValues.DEFAULT_BOOLEAN + "") boolean status) {
		Optional<Products> products = productsrepository.findById(productid);
		if (products.isPresent()) {
			products.get().setMaterialid(productid);
			products.get().setDescriptionid(descriptionid);
			products.get().setBatchid(batchid);
			products.get().setGenderid(genderid);
			products.get().setCatid(catid);
			products.get().setSubcatid(subcatid);
			products.get().setSeasonid(seasonid);
			products.get().setOccasionid(occasionid);
			products.get().setAgeid(ageid);
			products.get().setMaterialid(materialid);
			products.get().setColorid(colorid);
			products.get().setCustid(custid);
			products.get().setStatus(status);
		}
		Products product = productsrepository.save(products.get());
		if (product.getProductid() == productid) {
			ResponseBean responseBean = new ResponseBean(ConstantValues.DATA_UPDATED_IN_DB, HttpStatus.ACCEPTED.value(),
					System.currentTimeMillis());
			return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);
		} else {
			throw new DBDataNotUpdatedException(ConstantValues.DATA_NOT_UPDATED_IN_DB);
		}
	}

	@PutMapping(path = URLMapping.PRODUCTS_MAPPING_PATH_WITH_PATH_VARIABLE_1)
	@ResponseBody
	public ResponseEntity<ResponseBean> enableBatchStatus(@PathVariable long productid, @PathVariable boolean status) {
		Optional<Products> products = productsrepository.findById(productid);
		
		if (products.isPresent()) {
		if (products.get().getBatchid() != 0) {
			products.get().setStatus(status);
			Products product = productsrepository.save(products.get());
			if (product.getStatus() == status) {
				ResponseBean responseBean = new ResponseBean(ConstantValues.DATA_UPDATED_IN_DB,
						HttpStatus.ACCEPTED.value(), System.currentTimeMillis());
				return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);
			} else {
				throw new DBInsertException(ConstantValues.DATA_NOT_UPDATED_IN_DB);
			}

		} else {
			throw new BatchException(ConstantValues.BATCH_DETAILS_NOT_FOUND);
		}
		}
		else {
			throw new ProductException(ConstantValues.PRODUCT_NOT_FOUND);
		}
	}
}
