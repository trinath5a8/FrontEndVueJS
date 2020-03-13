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

import com.lc.sk.inventory.security.beans.OccasionalWear;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.rest.OccasionalWearRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.INVENTORY_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })

public class OccasionalWearService {

	@Autowired
	OccasionalWearRestService occasionalwearRestService;
	HttpHeaders header = new HttpHeaders();
	
	/* private int occasionid;		private String occaname;	rivate long subcatid; */
	
	@GetMapping(URLMapping.OCCASIONALWEAR_PATH)
	@ResponseBody
	public ResponseEntity<List<OccasionalWear>> getAllOccasionalWearDetails()
	{
		List<OccasionalWear> occasionalwear = occasionalwearRestService.getAllOccasionalWearDetails();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<OccasionalWear>>(occasionalwear, header, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping(URLMapping.OCCASIONALWEAR_PATH_WITH_ID)
	@ResponseBody
	public ResponseEntity<OccasionalWear> getOccasionalWearById(@PathVariable String occasionid)
	{
		OccasionalWear occasionalwear = occasionalwearRestService.getOccasionalWearById(occasionid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<OccasionalWear>(occasionalwear, header, HttpStatus.ACCEPTED);
	}
	
	@PostMapping(URLMapping.OCCASIONALWEAR_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insert(
			@RequestParam(name = ConstantValues.OCCANAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String occaname,
			@RequestParam(name = ConstantValues.SUBCATID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String subcatid
			)	
			
	{
		ResponseBean responseBean = occasionalwearRestService.InsertOccasionalWearDetails(occaname, subcatid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.ACCEPTED);
	}
	
	@PutMapping(URLMapping.OCCASIONALWEAR_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> update(
			@RequestParam(name = ConstantValues.OCCASIONID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String occasionid,
			@RequestParam(name = ConstantValues.OCCANAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String occaname,
			@RequestParam(name = ConstantValues.SUBCATID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String subcatid
			)
	{
		ResponseBean responseBean = occasionalwearRestService.UpdateOccasionalWearDetails(occasionid, occaname, subcatid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.ACCEPTED);
	}
}

