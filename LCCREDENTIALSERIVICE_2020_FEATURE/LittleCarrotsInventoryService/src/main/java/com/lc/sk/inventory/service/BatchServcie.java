/**
 * 
 */
package com.lc.sk.inventory.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.lc.sk.inventory.entities.Batch;
import com.lc.sk.inventory.exception.subexception.BatchException;
import com.lc.sk.inventory.exception.subexception.DBInsertException;
import com.lc.sk.inventory.exception.subexception.NullRequestReceivedException;
import com.lc.sk.inventory.repositories.BatchRepository;
import com.lc.sk.inventory.util.ConstantValues;
import com.lc.sk.inventory.util.HeaderComponent;
import com.lc.sk.inventory.util.URLMapping;

/**
 * @author Mastanvali Shaik LittleCarrotsInventoryService 2020
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(path = URLMapping.INVENTORY_ROOT_PATH)
public class BatchServcie {

	@Autowired
	BatchRepository batchRepository;

	@Autowired
	HeaderComponent hearders;
	

	public BatchServcie() {
	}

	/**
	 * @param warehouseid
	 * @param dateofpurchase
	 * @param purchasedby
	 * @param invamount
	 * @param whoinserted
	 * @param dateinsertion  --
	 * @param status
	 * @param isocode
	 * @param qty
	 * @param sellerid
	 */
	
	
	@GetMapping(path = URLMapping.BATCH_MAPPING_PATH)
	@ResponseBody
	public ResponseEntity<List<Batch>> getAllBatchList() {
		List<Batch> batches = (List<Batch>) batchRepository.findAll();
		if (!batches.isEmpty()) {
			return new ResponseEntity<>(batches, hearders.getHeader(), HttpStatus.ACCEPTED);

		} else {
			throw new BatchException(ConstantValues.BATCH_DETAILS_NOT_FOUND);
		}

	}

	@GetMapping(path = URLMapping.BATCH_MAPPING_PATH_WITH_PATH_VARIABLE)
	@ResponseBody
	public ResponseEntity<Optional<Batch>> getAllBatchList(@PathVariable long batchid) {
		Optional<Batch> batches = batchRepository.findById(batchid);
		if (!batches.isPresent()||batches.get()==null) {
			
			throw new BatchException(ConstantValues.BATCH_DETAILS_NOT_FOUND);
		} else {
			return new ResponseEntity<Optional<Batch>>(batches, hearders.getHeader(), HttpStatus.ACCEPTED);
		}

	}
	
	
	@PostMapping(path = URLMapping.BATCH_MAPPING_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insertBatch(
			@RequestParam(name = ConstantValues.WAREHOUSE_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long warehouseid,
			@RequestParam(name = ConstantValues.DATE_OF_PURCHASE, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String dateofpurchase,
			@RequestParam(name = ConstantValues.PURCHASE_BY, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String purchasedby,
			@RequestParam(name = ConstantValues.INV_AMOUNT, required = true, defaultValue = ConstantValues.DEFAULT_FLOAT) double invamount,
			@RequestParam(name = ConstantValues.WHO_INSERTED, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String whoinserted,
			@RequestParam(name = ConstantValues.WAREHOUSE_STATUS, required = true, defaultValue = ConstantValues.DEFAULT_INT) boolean status,
			@RequestParam(name = ConstantValues.ISOCODE, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String isocode,
			@RequestParam(name = ConstantValues.QUANTITY, required = true, defaultValue = ConstantValues.DEFAULT_INT) int quantity,
			@RequestParam(name = ConstantValues.SELLER_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long sellerid

	) {

		if (warehouseid == new Long(ConstantValues.DEFAULT_INT).longValue()
				|| dateofpurchase.equals(ConstantValues.DEFAULT_STRING)
				|| purchasedby.equals(ConstantValues.DEFAULT_STRING)
				|| invamount == new Double(ConstantValues.DEFAULT_INT).doubleValue()
				|| whoinserted.equals(ConstantValues.DEFAULT_STRING) || isocode.equals(ConstantValues.DEFAULT_STRING)
				|| quantity == new Integer(ConstantValues.DEFAULT_INT).intValue()
				|| sellerid == new Long(ConstantValues.DEFAULT_INT).longValue()) {
			throw new NullRequestReceivedException(ConstantValues.RECEIVED_NULL_VALUES);
		} else {
			java.sql.Timestamp dateinsertion = new java.sql.Timestamp(new java.util.Date().getTime());
			Date date1 = null;
			try {
				date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateofpurchase);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			java.sql.Timestamp dateofpurchase_1 = new java.sql.Timestamp(date1.getTime());
			Batch batch = batchRepository.save(new Batch(warehouseid, dateofpurchase_1, purchasedby, invamount,
					whoinserted, dateinsertion, status, isocode, quantity, sellerid));

			if (batch.getWarehouseid() == warehouseid) {
				ResponseBean responseBean = new ResponseBean(ConstantValues.DATA_INSERTED_IN_DB,
						HttpStatus.ACCEPTED.value(), System.currentTimeMillis());
				return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);
			} else {
				throw new DBInsertException(ConstantValues.DATA_NOT_INSERTED_IN_DB);
			}
		}

	}

	
	@PutMapping(path = URLMapping.BATCH_MAPPING_PATH_WITH_PATH_VARIABLE_1)
	@ResponseBody
	public ResponseEntity<ResponseBean> enableBatchStatus(@PathVariable long batchid, @PathVariable boolean status) {
		Optional<Batch> batches = batchRepository.findById(batchid);
		
		if(batches.isPresent()) {
		if (batches.get().getWarehouseid() != 0) {
			batches.get().setStatus(status);
			Batch bat = batchRepository.save(batches.get());
			if (bat.getStatus() == status) {
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
			throw new BatchException(ConstantValues.NO_BATCH_SERVICE_FOUND);
		}
	}

}
