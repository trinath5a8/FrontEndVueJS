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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.beans.SellerToWarehouse;
import com.lc.sk.inventory.security.rest.SellerToWarehouseRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.INVENTORY_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
public class SellerToWarehouseService {


	@Autowired
	SellerToWarehouseRestService sellerToWarehouseRestService;
	HttpHeaders header = new HttpHeaders();
	
	@PostMapping( URLMapping.WAREHOUSETOSELLER_POST)
	@ResponseBody	
	public ResponseEntity<ResponseBean> addList(
			@RequestParam(name = ConstantValues.WAREHOUSE_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String warehouseid,
			@RequestParam(name = ConstantValues.SELLER_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String sellerid) {
		ResponseBean responseBean = sellerToWarehouseRestService.addList(warehouseid, sellerid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);	
	}
	
	@GetMapping(URLMapping.WAREHOUSETOSELLER_GET)
	@ResponseBody
	public ResponseEntity<List<SellerToWarehouse>> getAll()
	{
    	List<SellerToWarehouse>  sellerToWarehouse= sellerToWarehouseRestService.getAllData();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<SellerToWarehouse>>(sellerToWarehouse, header, HttpStatus.OK);
	}
}
