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

import com.lc.sk.inventory.entities.ProductType;
import com.lc.sk.inventory.exception.subexception.DBInsertException;
import com.lc.sk.inventory.exception.subexception.NullRequestReceivedException;
import com.lc.sk.inventory.exception.subexception.ProductTypeNotFoundException;
import com.lc.sk.inventory.repositories.ProductTypeRepository;
import com.lc.sk.inventory.util.ConstantValues;
import com.lc.sk.inventory.util.HeaderComponent;
import com.lc.sk.inventory.util.SecurityHttpStatus;
import com.lc.sk.inventory.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(path = URLMapping.INVENTORY_ROOT_PATH)
public class ProductTypeService {

	@Autowired
	ProductTypeRepository producttypeRepository;

	@Autowired
	HeaderComponent hearders;

	@GetMapping(path = URLMapping.PRODUCTTYPE_PATH)
	@ResponseBody
	public ResponseEntity<List<ProductType>> getAllProductTypeDetails() {
		List<ProductType> producttype = (List<ProductType>) producttypeRepository.findAll();

		if (producttype.isEmpty()) {
			throw new ProductTypeNotFoundException(ConstantValues.NO_PRODUCT_TYPE_DETAILS_FOUND);
		} else {
			return new ResponseEntity<List<ProductType>>(producttype, hearders.getHeader(), HttpStatus.ACCEPTED);
		}

	}

	@GetMapping(path = URLMapping.PRODUCTTYPE_PATH_WITH_ID)
	@ResponseBody
	public ResponseEntity<Optional<ProductType>> getProductTypeById(@PathVariable long protypeid) {
		Optional<ProductType> producttype = producttypeRepository.findById(protypeid);
		if (producttype.isPresent()) {
			return new ResponseEntity<Optional<ProductType>>(producttype, hearders.getHeader(), HttpStatus.ACCEPTED);
		} else {
			throw new ProductTypeNotFoundException(ConstantValues.NO_PRODUCT_TYPE_FOUND_WITH_GIVEN_ID);
		}

	}

	@PostMapping(path = URLMapping.PRODUCTTYPE_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insertColor(

			@RequestParam(name = ConstantValues.SUBCAT_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long subcatid,
			@RequestParam(name = ConstantValues.PRODUCTTYPE_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String producttypename

	) {
		if (subcatid == new Long(ConstantValues.DEFAULT_INT).longValue()
				|| producttypename.equals(ConstantValues.DEFAULT_STRING)) {
			throw new NullRequestReceivedException(ConstantValues.RECEIVED_NULL_VALUES);
		}

		else {

			ProductType producttype = producttypeRepository.save(new ProductType(subcatid, producttypename));

			if (producttype.getSubcatid() == subcatid) {
				ResponseBean responseBean = new ResponseBean(ConstantValues.DATA_INSERTED_IN_DB,
						SecurityHttpStatus.ACCEPTED, System.currentTimeMillis());

				return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);
			} else {
				throw new DBInsertException(ConstantValues.DATA_NOT_INSERTED_IN_DB);
			}

		}
	}

	@PutMapping(path = URLMapping.PRODUCTTYPE_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> enableProductTypeStatus(
			@RequestParam(name = ConstantValues.PROTYPE_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long protypeid,
			@RequestParam(name = ConstantValues.SUBCAT_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long subcatid,
			@RequestParam(name = ConstantValues.PRODUCTTYPE_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String producttypename) {
		Optional<ProductType> protype = producttypeRepository.findById(protypeid);
		if (protype.isPresent()) {
			protype.get().setSubcatid(subcatid);
			protype.get().setProducttypename(producttypename);
			ProductType protype1 = producttypeRepository.save(protype.get());

			if (protype1.getSubcatid() == subcatid) {
				ResponseBean responseBean = new ResponseBean(ConstantValues.DATA_UPDATED_IN_DB,
						SecurityHttpStatus.ACCEPTED, System.currentTimeMillis());
				return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);
			} else {
				throw new DBInsertException(ConstantValues.DATA_NOT_UPDATED_IN_DB);
			}
		}

		else {
			throw new ProductTypeNotFoundException(ConstantValues.NO_PRODUCT_TYPE_DETAILS_FOUND);

		}

	}
}
