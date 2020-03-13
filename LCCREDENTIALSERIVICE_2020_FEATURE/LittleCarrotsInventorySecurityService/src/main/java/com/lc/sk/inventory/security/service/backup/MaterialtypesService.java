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
import com.lc.sk.inventory.security.beans.Materialtypes;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.rest.MaterialtypesRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.INVENTORY_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
public class MaterialtypesService {

	@Autowired
	MaterialtypesRestService materialtypesRestService;
	HttpHeaders header = new HttpHeaders();
	
	@GetMapping(URLMapping.MATERIAL_GET_PATH)
	@ResponseBody
	public ResponseEntity<List<Materialtypes>> getAllMaterialtypes()
	{
		List<Materialtypes> materialtypes = materialtypesRestService.getAllMaterialtypes();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<Materialtypes>>(materialtypes, header, HttpStatus.ACCEPTED);
	}


	@GetMapping(URLMapping.MATERIALTYPE_GET_PATH_WITH_VARIABLE)
	@ResponseBody
	public ResponseEntity<Materialtypes> getMaterialtypeById(@PathVariable String materialid)
	{
		Materialtypes materialtypes = materialtypesRestService.getMaterialtypeById(materialid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<Materialtypes>(materialtypes, header, HttpStatus.ACCEPTED);
	}
	
	@PostMapping(URLMapping.MATERIAL_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insert(
			@RequestParam(name = ConstantValues.MATERIAL_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String materialname,
			@RequestParam(name = ConstantValues.DESCRIPTION, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String description,
			@RequestParam(name = ConstantValues.OCCASION_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String occasionid,
			@RequestParam(name = ConstantValues.SEASON_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE)  String seasonid,
			@RequestParam(name = ConstantValues.CATEGORY_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE)  String catid
			
			)
	{
		ResponseBean responseBean = materialtypesRestService.insertMaterialtype(materialname, description, occasionid, seasonid,  catid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.ACCEPTED);
	}
	
	@PutMapping(URLMapping.MATERIAL_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> update(
			@RequestParam(name = ConstantValues.MATERIAL_NAME, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String materialname,
			@RequestParam(name = ConstantValues.DESCRIPTION, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String description,
			@RequestParam(name = ConstantValues.OCCASION_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String occasionid,
			@RequestParam(name = ConstantValues.SEASON_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE)  String seasonid,
			@RequestParam(name = ConstantValues.CATEGORY_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE)  String catid,
			@RequestParam(name = ConstantValues.MATERIAL_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE)  String materialid
			)
	{
		ResponseBean responseBean = materialtypesRestService.updateMaterialtype( materialid,materialname, description, occasionid, seasonid, catid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.ACCEPTED);
	}
}
