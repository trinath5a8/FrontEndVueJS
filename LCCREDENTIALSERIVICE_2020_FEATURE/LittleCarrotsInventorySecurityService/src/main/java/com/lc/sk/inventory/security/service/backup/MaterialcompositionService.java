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

import com.lc.sk.inventory.security.beans.Materialcomposition;
import com.lc.sk.inventory.security.beans.ResponseBean;
import com.lc.sk.inventory.security.rest.MaterialcompositionRestService;
import com.lc.sk.inventory.security.util.ConstantValues;
import com.lc.sk.inventory.security.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(value = URLMapping.INVENTORY_ROOT_PATH, produces = { MediaType.APPLICATION_JSON_VALUE })
public class MaterialcompositionService {
	@Autowired
	MaterialcompositionRestService materialcompositionRestService;
	HttpHeaders header = new HttpHeaders();
	
	@GetMapping(URLMapping.MATERIALCOMP_GET_PATH)
	@ResponseBody
	public ResponseEntity<List<Materialcomposition>> getAllMaterialcomposition()
	{
		List<Materialcomposition> materialcomposition = materialcompositionRestService.getAllMaterialcomposition();
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<List<Materialcomposition>>(materialcomposition, header, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(URLMapping.MATERIALCOMPOSITION_GET_PATH_WITH_VARIABLE)
	@ResponseBody
	public ResponseEntity<Materialcomposition> getMaterialcompositionById(@PathVariable String materialid)
	{
		Materialcomposition materialcomposition = materialcompositionRestService.getMaterialcompositionById(materialid);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<Materialcomposition>(materialcomposition, header, HttpStatus.ACCEPTED);
	}
	
	@PostMapping(URLMapping.MATERIALCOMP_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> insert(
			@RequestParam(name = ConstantValues.MATERIAL_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String materialid,
			@RequestParam(name = ConstantValues.DESCRIPTION, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String description
			
			
			)
	{
		ResponseBean responseBean = materialcompositionRestService.insertMaterialcomposition(materialid, description);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.ACCEPTED);
	}
	
	@PutMapping(URLMapping.MATERIALCOMP_GET_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> update(
			@RequestParam(name = ConstantValues.MATERIAL_ID, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String materialid,
			@RequestParam(name = ConstantValues.DESCRIPTION, required = true, defaultValue = ConstantValues.DEFAULT_STRING_VALUE) String description
			
			)
	{
		ResponseBean responseBean = materialcompositionRestService.updateMaterialcomposition( materialid, description);
		header.add("Server", "SecurityServiceInventory");
		return new ResponseEntity<ResponseBean>(responseBean, header, HttpStatus.ACCEPTED);
	}
}

