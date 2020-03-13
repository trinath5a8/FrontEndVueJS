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

import com.lc.sk.inventory.security.beans.Batch;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.rest.BatchRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.INVENTORY_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })

public class BatchService {

	@Autowired
	BatchRestService batchRestService;
	HttpHeaders header = new HttpHeaders();
	
	@GetMapping(URLMapping.BATCHES_GET_PATH)
	@ResponseBody
	public ResponseEntity<List<Batch>> getAllBatchList()
	{
		List<Batch> batches = batchRestService.getAllBatchList();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<Batch>>(batches, header, HttpStatus.ACCEPTED);
	}
	
	@PostMapping(URLMapping.BATCHES_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insert(
			@RequestParam(name = ConstantValues.WAREHOUSE_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String warehouseid,
			@RequestParam(name = ConstantValues.DATE_OF_PURCHASE, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String dateofpurchase,
			@RequestParam(name = ConstantValues.PURCHASE_BY, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String purchasedby,
			@RequestParam(name = ConstantValues.INV_AMOUNT, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String invamount,
			@RequestParam(name = ConstantValues.WHO_INSERTED, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String whoinserted,
			@RequestParam(name = ConstantValues.WAREHOUSE_STATUS, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) boolean status,
			@RequestParam(name = ConstantValues.ISOCODE, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String isocode,
			@RequestParam(name = ConstantValues.QUANTITY, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String qty,
			@RequestParam(name = ConstantValues.SELLER_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String sellerid
			)
	{
		ResponseBean responseBean = batchRestService.insertBatch(warehouseid,  dateofpurchase,  purchasedby,  invamount,
				 whoinserted,  status,  isocode,  qty,  sellerid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.ACCEPTED);
	}
	
	@PutMapping(URLMapping.BATCHID_PUT_PATH_WITH_VARIABLE)
	@ResponseBody
	public ResponseEntity<ResponseBean> updateBatch(@PathVariable String batchid, @PathVariable String status)
	{
		ResponseBean responseBean = batchRestService.updateBatch(batchid, status);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(URLMapping.BATCHES_MAPPING_PATH_WITH_PATH_VARIABLE)
	@ResponseBody
	public ResponseEntity<Batch> getBatchById(@PathVariable String batchid)
	{
		Batch batch = batchRestService.getBatchById(batchid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<Batch>(batch, header, HttpStatus.ACCEPTED);
	}
	
}
