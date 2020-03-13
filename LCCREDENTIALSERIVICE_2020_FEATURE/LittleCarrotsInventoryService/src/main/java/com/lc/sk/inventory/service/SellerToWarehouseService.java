/**
 * 
 */
package com.lc.sk.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lc.sk.inventory.bean.ResponseBean;
import com.lc.sk.inventory.entities.SellerToWarehouse;
import com.lc.sk.inventory.exception.subexception.DBInsertException;
import com.lc.sk.inventory.exception.subexception.SellerToWarehouseException;
import com.lc.sk.inventory.repositories.SellerToWarehouseRepository;
import com.lc.sk.inventory.util.ConstantValues;
import com.lc.sk.inventory.util.HeaderComponent;
import com.lc.sk.inventory.util.SecurityHttpStatus;
import com.lc.sk.inventory.util.URLMapping;

/**
 * @author Mastanvali Shaik LittleCarrotsInventoryService 2020
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(path = URLMapping.INVENTORY_ROOT_PATH)
public class SellerToWarehouseService {

	@Autowired
	SellerToWarehouseRepository sellerToWarehouseRepository;

	@Autowired
	HeaderComponent hearders;

	public SellerToWarehouseService() {
	}

	@PostMapping(URLMapping.POST_SUBMIT_WAREHOUSE_TO_SELLER)
	@ResponseBody
	public ResponseEntity<ResponseBean> addList(
			@RequestParam(name = ConstantValues.WAREHOUSE_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING) long warehouseid,
			@RequestParam(name = ConstantValues.SELLER_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING) long sellerid) {
		ResponseBean responseBean = new ResponseBean();

		SellerToWarehouse selltoware = sellerToWarehouseRepository.save(new SellerToWarehouse(warehouseid, sellerid));
		if (selltoware.getSellerid() == sellerid && selltoware.getWarehouseid() == warehouseid) {
			responseBean.setMessage(ConstantValues.DATA_INSERTED_IN_DB);
			responseBean.setResponsecode(SecurityHttpStatus.ACCEPTED);
			responseBean.setTiemstamp(System.currentTimeMillis());
			return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);

		} else {
			throw new DBInsertException(ConstantValues.DATA_NOT_INSERTED_IN_DB);
		}

	}

	
	@GetMapping(URLMapping.POST_SUBMIT_WAREHOUSE_TO_SELLER)
	@ResponseBody
	public ResponseEntity<List<SellerToWarehouse>> getAllData()
	{
		List<SellerToWarehouse> list = (List<SellerToWarehouse>) sellerToWarehouseRepository.findAll();
		
		if(!list.isEmpty())
		{
			return new ResponseEntity<List<SellerToWarehouse>>(list, hearders.getHeader(), HttpStatus.ACCEPTED);
		}
		else
		{
			throw new SellerToWarehouseException(ConstantValues.SELLER_WAREHOUSE_RELATION_NOT_FOUND);
		}
	}
}
