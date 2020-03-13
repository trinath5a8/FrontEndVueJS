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
import com.lc.sk.inventory.entities.PricesTable;
import com.lc.sk.inventory.exception.subexception.DBInsertException;
import com.lc.sk.inventory.exception.subexception.NullRequestReceivedException;
import com.lc.sk.inventory.exception.subexception.PricesTableException;
import com.lc.sk.inventory.repositories.PricesTableRepository;
import com.lc.sk.inventory.util.ConstantValues;
import com.lc.sk.inventory.util.HeaderComponent;
import com.lc.sk.inventory.util.SecurityHttpStatus;
import com.lc.sk.inventory.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(path = URLMapping.INVENTORY_ROOT_PATH)
public class PricesTableSevice {

	@Autowired
	PricesTableRepository pricesTableRepository;

	@Autowired
	HeaderComponent hearders;

	// Get all Prices
	@GetMapping(path = URLMapping.PRICES_TABLE)
	@ResponseBody
	public ResponseEntity<List<PricesTable>> getallprices() {
		List<PricesTable> pricesTable = (List<PricesTable>) pricesTableRepository.findAll();
		if (pricesTable.isEmpty()) {
			throw new PricesTableException(ConstantValues.PRICE_ID_NOT_FOUND);
		} else {
			return new ResponseEntity<List<PricesTable>>(pricesTable, hearders.getHeader(), HttpStatus.ACCEPTED);
		}
	}

	// Get Price by ID
	@GetMapping(path = URLMapping.PRICES_TABLE_BY_ID)
	@ResponseBody
	public ResponseEntity<Optional<PricesTable>> getpricebyid(@PathVariable long priceId) {
		Optional<PricesTable> pricesTable = pricesTableRepository.findById(priceId);
		if (pricesTable.isPresent()) {
			return new ResponseEntity<Optional<PricesTable>>(pricesTable, hearders.getHeader(), HttpStatus.ACCEPTED);
		} else {
			throw new PricesTableException(ConstantValues.PRICE_ID_NOT_FOUND);
		}
	}

	// Insertion
	@PostMapping(path = URLMapping.PRICES_TABLE)
	@ResponseBody
	public ResponseEntity<ResponseBean> insertprices(
			@RequestParam(name = ConstantValues.MRP, required = true, defaultValue = ConstantValues.DEFAULT_FLOAT) float mrp,
			@RequestParam(name = ConstantValues.PRODUCT_ID, required = true, defaultValue = ConstantValues.DEFAULT_FLOAT) long productId,
			@RequestParam(name = ConstantValues.lC_PRICE, required = true, defaultValue = ConstantValues.DEFAULT_FLOAT) float lcPrice,
			@RequestParam(name = ConstantValues.TAX, required = true, defaultValue = ConstantValues.DEFAULT_FLOAT) float tax,
			@RequestParam(name = ConstantValues.SELLING_PRICE, required = true, defaultValue = ConstantValues.DEFAULT_FLOAT) float sellingPrice,
			@RequestParam(name = ConstantValues.FINAL_PRICE, required = true, defaultValue = ConstantValues.DEFAULT_FLOAT) float finalPrice) {
		System.err.println("At invent:Productid:"+productId);
		if (mrp == new Float(ConstantValues.DEFAULT_FLOAT).floatValue()
				|| productId == new Long(ConstantValues.DEFAULT_FLOAT).longValue()
				|| lcPrice == new Float(ConstantValues.DEFAULT_FLOAT).floatValue()
				|| tax == new Float(ConstantValues.DEFAULT_FLOAT).floatValue()
				|| sellingPrice == new Float(ConstantValues.DEFAULT_FLOAT).floatValue()
				|| finalPrice == new Float(ConstantValues.DEFAULT_FLOAT).floatValue()) {
			throw new NullRequestReceivedException(ConstantValues.RECEIVED_NULL_VALUES);
		} else {
			PricesTable pricesTable = new PricesTable(mrp, productId, lcPrice, tax, sellingPrice, finalPrice);
			pricesTable = pricesTableRepository.save(pricesTable);
			if (pricesTable.getProductId() == productId) {
				ResponseBean responseBean = new ResponseBean(ConstantValues.DATA_INSERTED_IN_DB,
						SecurityHttpStatus.ACCEPTED, System.currentTimeMillis());
				return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);
			} else {
				throw new DBInsertException(ConstantValues.DATA_NOT_INSERTED_IN_DB);
			}
		}
	}

	// Updation
	@PutMapping(path = URLMapping.PRICES_TABLE)
	public ResponseEntity<ResponseBean> updatePriceTable(
			@RequestParam(name = ConstantValues.PRICE_ID, required = true, defaultValue = ConstantValues.DEFAULT_FLOAT) long priceId,
			@RequestParam(name = ConstantValues.MRP, required = true, defaultValue = ConstantValues.DEFAULT_FLOAT) float mrp,
			@RequestParam(name = ConstantValues.PRODUCT_ID, required = true, defaultValue = ConstantValues.DEFAULT_FLOAT) long productId,
			@RequestParam(name = ConstantValues.lC_PRICE, required = true, defaultValue = ConstantValues.DEFAULT_FLOAT) float lcPrice,
			@RequestParam(name = ConstantValues.TAX, required = true, defaultValue = ConstantValues.DEFAULT_FLOAT) float tax,
			@RequestParam(name = ConstantValues.SELLING_PRICE, required = true, defaultValue = ConstantValues.DEFAULT_FLOAT) float sellingPrice,
			@RequestParam(name = ConstantValues.FINAL_PRICE, required = true, defaultValue = ConstantValues.DEFAULT_FLOAT) float finalPrice) {
		//Optional<PricesTable> pricesTable = pricesTableRepository.findById(productId);
		Optional<PricesTable> pricesTable= pricesTableRepository.findById(priceId);
		System.out.println(pricesTable);
		if (pricesTable.isPresent()) {
			pricesTable.get().setMrp(mrp);
			pricesTable.get().setLcPrice(lcPrice);
			pricesTable.get().setTax(tax);
			pricesTable.get().setSellingPrice(sellingPrice);
			pricesTable.get().setFinalPrice(finalPrice);
			PricesTable pricesTable1 = pricesTableRepository.save(pricesTable.get());
			if (pricesTable1.getProductId() == productId) {
				ResponseBean responseBean = new ResponseBean(ConstantValues.DATA_UPDATED_IN_DB,
						SecurityHttpStatus.ACCEPTED, System.currentTimeMillis());
				return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);
			} else {
				throw new DBInsertException(ConstantValues.DATA_NOT_UPDATED_IN_DB);
			}
		} else {
			throw new PricesTableException(ConstantValues.PRICE_ID_NOT_FOUND);
			
		}/*
		ResponseBean responseBean = new ResponseBean(ConstantValues.DATA_UPDATED_IN_DB,
				HttpStatus.ACCEPTED.value(), System.currentTimeMillis());
		return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);*/
	}
	}