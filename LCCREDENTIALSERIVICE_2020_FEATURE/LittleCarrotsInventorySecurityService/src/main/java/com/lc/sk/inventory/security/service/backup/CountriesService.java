/**
 * 
 */
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lc.sk.inventory.security.beans.Countries;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.rest.CountriesRestService;
import com.lc.sk.inventory.security.util.URLMapping;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsInventorySecurityService
 * 2020
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.INVENTORY_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
public class CountriesService {

	
	@Autowired
	CountriesRestService countriesRestService;
	HttpHeaders header = new HttpHeaders();
	
	@GetMapping(URLMapping.COUNTRY_GET_PATH)
	@ResponseBody
	public ResponseEntity<List<Countries>> getAllCountries()
	{
		List<Countries> countries = countriesRestService.getAllCountries();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<Countries>>(countries, header, HttpStatus.OK);
	}
	
	@GetMapping(URLMapping.COUNTRY_GET_PATH_WITH_VARIABLE)
	@ResponseBody
	public ResponseEntity<Countries> getCountryById(@PathVariable String isocode)
	{
		Countries country = countriesRestService.getCountryById(isocode);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<Countries>(country, header, HttpStatus.OK);
	}
	
	@PutMapping(URLMapping.COUNTRY_PUT_PATH_WITH_VARIABLE)
	@ResponseBody
	public ResponseEntity<ResponseBean> enableCountry(@PathVariable String isocode, @PathVariable boolean status)
	{
		ResponseBean responseBean = countriesRestService.enableCountry(isocode, status);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
	}
	
	
	@GetMapping(URLMapping.COUNTRY_ACTIVE_GET)
	@ResponseBody
	public ResponseEntity<List<Countries>> getActivecountries()
	{
		List<Countries> countries = countriesRestService.getActiveCountries();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<Countries>>(countries, header, HttpStatus.OK);
	}
}
