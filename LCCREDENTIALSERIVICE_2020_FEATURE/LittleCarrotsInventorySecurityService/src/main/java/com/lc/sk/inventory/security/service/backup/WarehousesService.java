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

import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.beans.Warehouses;
import com.lc.sk.inventory.security.rest.WarehousesRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.INVENTORY_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })

public class WarehousesService {
	
	@Autowired
	WarehousesRestService warehousesRestService;
	HttpHeaders header = new HttpHeaders();
	
	@GetMapping(URLMapping.WAREHOUSES_GET_PATH)
	@ResponseBody
	public ResponseEntity<List<Warehouses>> getAllWarehouseDetails()
	{
		List<Warehouses> warehouses = warehousesRestService.getAllWarehouses();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<Warehouses>>(warehouses, header, HttpStatus.OK);
	}
	
	@GetMapping(URLMapping.WAREHOUSES_MAPPING_PATH_WITH_PATH_VARIABLE)
	@ResponseBody
	public ResponseEntity<Warehouses> getById(@PathVariable String warehouseid)
	{
		Warehouses warehouse = warehousesRestService.getById(warehouseid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<Warehouses>(warehouse, header, HttpStatus.OK);
	}

	@PostMapping(URLMapping.WAREHOUSES_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insert(
			@RequestParam(name = ConstantValues.WAREHOUSE_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String warehousename,
			@RequestParam(name = ConstantValues.CONTACT_PERSON_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String contactpersonname,
			@RequestParam(name = ConstantValues.CONTACT_PERSON_PHONE, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String contactphone,
			@RequestParam(name = ConstantValues.WAREHOUSE_EMAIL_ADDRESS, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String email,
			@RequestParam(name = ConstantValues.WAREHOUSE_ADDRESS, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String address,
			@RequestParam(name = ConstantValues.WHAREHOUSE_PIN, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String pincode,
			@RequestParam(name = ConstantValues.WAREHOUSE_EST, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String est,
			@RequestParam(name = ConstantValues.WAREHOUSE_STATUS, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) boolean status,
			@RequestParam(name = ConstantValues.WHO_CREATED, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String username,
			@RequestParam(name = ConstantValues.ISOCODE, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String isocode
			
			)
	{
		ResponseBean responseBean = warehousesRestService.insertNewWarehouse( warehousename, contactpersonname, contactphone, email, address, pincode,
				 est, status, username,username, isocode);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
	}
	
	@PutMapping(URLMapping.WAREHOUSES_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> update(
			@RequestParam(name = ConstantValues.WAREHOUSE_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String warehouseid,
			@RequestParam(name = ConstantValues.WAREHOUSE_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String warehousename,
			@RequestParam(name = ConstantValues.CONTACT_PERSON_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String contactpersonname,
			@RequestParam(name = ConstantValues.CONTACT_PERSON_PHONE, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String contactphone,
			@RequestParam(name = ConstantValues.WAREHOUSE_EMAIL_ADDRESS, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String email,
			@RequestParam(name = ConstantValues.WAREHOUSE_ADDRESS, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String address,
			@RequestParam(name = ConstantValues.WHAREHOUSE_PIN, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String pincode,
			@RequestParam(name = ConstantValues.WAREHOUSE_EST, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String est,
			@RequestParam(name = ConstantValues.WAREHOUSE_STATUS, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String status,
			@RequestParam(name = ConstantValues.WHO_UPDATED, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String username,
			@RequestParam(name = ConstantValues.ISOCODE, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String isocode
			)
	{
		ResponseBean responseBean = warehousesRestService.update( warehouseid, warehousename, contactpersonname, contactphone, email, address, pincode,
				 est, status, username, isocode );
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
	}
	
}
