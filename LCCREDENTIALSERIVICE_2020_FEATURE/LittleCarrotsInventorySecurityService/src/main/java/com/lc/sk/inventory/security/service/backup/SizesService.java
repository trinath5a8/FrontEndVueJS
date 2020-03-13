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
import com.lc.sk.inventory.security.beans.Sizes;
import com.lc.sk.inventory.security.rest.SizesRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.INVENTORY_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
public class SizesService {

	@Autowired
	SizesRestService sizesRestService;
	HttpHeaders header = new HttpHeaders();
	
	@PostMapping(path = URLMapping.SIZES_MAPPING_PATH)
	@ResponseBody	
	public ResponseEntity<ResponseBean> insertSeasonWear(
			@RequestParam(name=ConstantValues.AGE_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String ageid,
			@RequestParam(name=ConstantValues.SIZE_NO, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String sizeno,
			@RequestParam(name=ConstantValues.HEIGHT, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String height,
			@RequestParam(name=ConstantValues.WEIGHT, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String weight,
			@RequestParam(name=ConstantValues.CHEST, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String chest,
			@RequestParam(name=ConstantValues.WAIST, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String waist,
			@RequestParam(name=ConstantValues.HIP, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String hip)
			{
		ResponseBean responseBean = sizesRestService.insertSeasonWear(ageid, sizeno,height,weight,chest,waist,hip);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);	
	}
	
	@PutMapping(path = URLMapping.SIZES_MAPPING_PATH)
	@ResponseBody	
	public ResponseEntity<ResponseBean> updatesize(
			@RequestParam(name=ConstantValues.SIZE_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String sizeid,
			@RequestParam(name=ConstantValues.AGE_ID, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String ageid,
			@RequestParam(name=ConstantValues.SIZE_NO, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String sizeno,
			@RequestParam(name=ConstantValues.HEIGHT, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String height,
			@RequestParam(name=ConstantValues.WEIGHT, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String weight,
			@RequestParam(name=ConstantValues.CHEST, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String chest,
			@RequestParam(name=ConstantValues.WAIST, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String waist,
			@RequestParam(name=ConstantValues.HIP, required = true , defaultValue=ConstantValues.DEFAULT_STRING_VALUE) String hip)
			{
		ResponseBean responseBean = sizesRestService.updatesize(sizeid,ageid, sizeno,height,weight,chest,waist,hip);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);	
	}
	
	@GetMapping(URLMapping.SIZES_MAPPING_PATH_WITH_ID)
	@ResponseBody
	public ResponseEntity<Sizes> getById(@PathVariable String sizeid)
	{
		Sizes sizes = sizesRestService.getsizebyid(sizeid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<Sizes>(sizes, header, HttpStatus.OK);
	}
	
	@GetMapping(URLMapping.SIZES_MAPPING_PATH)
	@ResponseBody
	public ResponseEntity<List<Sizes>> getAllSizes()
	{
		List<Sizes> sizes = sizesRestService.getAllSizes();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<Sizes>>(sizes, header, HttpStatus.OK);
	}
}
