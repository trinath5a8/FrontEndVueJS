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
import com.lc.sk.inventory.security.beans.SeasonWear;
import com.lc.sk.inventory.security.rest.SeasonWearRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.INVENTORY_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })

public class SeasonWearService {

	@Autowired
	SeasonWearRestService seasonwearRestService;
	HttpHeaders header = new HttpHeaders();
	
	@GetMapping(URLMapping.SEASON_WEAR)
	@ResponseBody
	public ResponseEntity<List<SeasonWear>> getAllSeasonWearDetails()
	{
		List<SeasonWear> seasonwear = seasonwearRestService.getAllSeasonWearDetails();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<SeasonWear>>(seasonwear, header, HttpStatus.OK);
	}
	
	
	@GetMapping(URLMapping.SEASON_WEAR_BY_ID)
	@ResponseBody
	public ResponseEntity<SeasonWear> getSeasonWearById(@PathVariable String seasonid)
	{
		SeasonWear seasonwear = seasonwearRestService.getSeasonWearById(seasonid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<SeasonWear>(seasonwear, header, HttpStatus.OK);
	}
	
	@PostMapping(URLMapping.SEASON_WEAR)
	@ResponseBody
	public ResponseEntity<ResponseBean> insert(
			@RequestParam(name = ConstantValues.SUBCATID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String subcatid,
			@RequestParam(name = ConstantValues.SEASON, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String season
			)	
			
	{
		ResponseBean responseBean = seasonwearRestService.InsertSeasonWearDetails(subcatid, season);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
	}
	
	@PutMapping(URLMapping.SEASON_WEAR)
	@ResponseBody
	public ResponseEntity<ResponseBean> update(
			@RequestParam(name = ConstantValues.SEASON_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String seasonid,
			@RequestParam(name = ConstantValues.SUBCATID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String subcatid,
			@RequestParam(name = ConstantValues.SEASON, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String season
			)
	{
		ResponseBean responseBean = seasonwearRestService.UpdateSeasonWearDetails(seasonid, subcatid, season);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
	}
}
	
	



