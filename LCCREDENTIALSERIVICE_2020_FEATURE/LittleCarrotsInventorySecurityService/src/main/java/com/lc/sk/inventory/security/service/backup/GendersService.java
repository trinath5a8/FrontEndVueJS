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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lc.sk.inventory.security.beans.Genders;
import com.lc.sk.inventory.security.rest.GendersRestService;
import com.lc.sk.inventory.security.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.INVENTORY_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })

public class GendersService {
	@Autowired
	GendersRestService gendersRestService;
	HttpHeaders header = new HttpHeaders();
	
	@GetMapping(URLMapping.GENDERS_GET_PATH)
	@ResponseBody
	public ResponseEntity<List<Genders>> getAllGendersDetails()
	{
		List<Genders> genders = gendersRestService.getAllGendersDetails();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<Genders>>(genders, header, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(URLMapping.GENDERS_MAPPING_PATH_WITH_PATH_VARIABLE)
	@ResponseBody
	public ResponseEntity<Genders> getGenderById(@PathVariable String genderid)
	{
		Genders genders = gendersRestService.getGenderById(genderid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<Genders>(genders, header, HttpStatus.ACCEPTED);
	}
	
}
