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

import com.lc.sk.inventory.security.beans.Color;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.rest.ColorRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.INVENTORY_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
public class ColorService {


	@Autowired
	
	ColorRestService   colorRestService;
	HttpHeaders header = new HttpHeaders();
	
	@PostMapping(URLMapping.COLOR_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insertNewColor(
			@RequestParam(name = ConstantValues.COLOR_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String colorname,
			@RequestParam(name = ConstantValues.HASHCODE, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String hashcode
			
			)
	{
		ResponseBean responseBean = colorRestService.insertNewColor(colorname,hashcode);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
	}
	
	
	@PutMapping(URLMapping.COLOR_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> updateColor(
			@RequestParam(name = ConstantValues.COLOR_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String colorid,
			@RequestParam(name = ConstantValues.COLOR_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String colorname,
			@RequestParam(name = ConstantValues.HASHCODE, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String hashcode
			
			)
	{
		ResponseBean responseBean = colorRestService.updateColor(colorid,colorname,hashcode);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.OK);
	}
	
	@GetMapping(URLMapping.COLOR_PATH)
	@ResponseBody
	public ResponseEntity<List<Color>> getAllColors(
			)
	{
		List<Color> responseBean = colorRestService.getAllColors();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<Color>>(responseBean, header, HttpStatus.OK);
	}
	
	
	@GetMapping(URLMapping.COLOR_PATH_WITH_COLOR_ID)
	@ResponseBody
	public ResponseEntity<Color> getColorById(@PathVariable String colorid)
			
	{
		Color responseBean = colorRestService.getColorById(colorid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<Color>(responseBean, header, HttpStatus.OK);
	}
	
/*
	@GetMapping(URLMapping.COLOR_ACTIVE_PATH)
	@ResponseBody
	public ResponseEntity<List<Color>> getActiveColors()
	{
		List<Color> responseBean = colorRestService.getActiveColors();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<Color>>(responseBean, header, HttpStatus.OK);
	}
	*/
	}
