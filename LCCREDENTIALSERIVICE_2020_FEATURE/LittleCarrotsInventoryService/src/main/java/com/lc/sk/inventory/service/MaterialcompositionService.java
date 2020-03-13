package com.lc.sk.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lc.sk.inventory.bean.ResponseBean;
import com.lc.sk.inventory.entities.Materialcomposition;
import com.lc.sk.inventory.exception.subexception.DBInsertException;
import com.lc.sk.inventory.exception.subexception.MaterialcompositionException;
import com.lc.sk.inventory.exception.subexception.NullRequestReceivedException;
import com.lc.sk.inventory.repositories.MaterialcompositionRepository;
import com.lc.sk.inventory.util.ConstantValues;
import com.lc.sk.inventory.util.HeaderComponent;
import com.lc.sk.inventory.util.SecurityHttpStatus;
import com.lc.sk.inventory.util.URLMapping;

@RestController
@Validated
@RequestMapping(path = URLMapping.INVENTORY_ROOT_PATH)

public class MaterialcompositionService {
	@Autowired
	MaterialcompositionRepository materialcompositionrepository;
	@Autowired
	HeaderComponent hearders;

	public MaterialcompositionService() {

	}

	@GetMapping(path = URLMapping.MATERIALCOMPOSITION_MAPPING_PATH)
	@ResponseBody
	public ResponseEntity<List<Materialcomposition>> getAllMaterialcomposition() {
		List<Materialcomposition> materialcomposition = (List<Materialcomposition>) materialcompositionrepository
				.findAll();
		if (materialcomposition.isEmpty()) {
			throw new MaterialcompositionException(ConstantValues.EMPTY_MATERIALCOMPOSITION_LIST);
		} else {

			return new ResponseEntity<List<Materialcomposition>>(materialcomposition, hearders.getHeader(),
					HttpStatus.ACCEPTED);
		}

	}

	@GetMapping(path = URLMapping.GET_ALL_MATERIALCOMPOSITION_LIST_BY_ID)
	@ResponseBody
	public ResponseEntity<Optional<Materialcomposition>> getById(@PathVariable long materialid) {
		Optional<Materialcomposition> materialcomposition = materialcompositionrepository.findById(materialid);
		if (materialcomposition.isPresent()&&   materialcomposition.get() != null) {
			return new ResponseEntity<Optional<Materialcomposition>>(materialcomposition, hearders.getHeader(),
					HttpStatus.ACCEPTED);
		
		} else {

			throw new MaterialcompositionException(ConstantValues.MATERIALCOMPOSITION_NOT_FOUND_WITH_GIVEN_ID);
		}
	}

	@PostMapping(path = URLMapping.MATERIALCOMPOSITION_MAPPING_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> addList(
			@RequestParam(name = ConstantValues.MATERIAL_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long materialid,
			@RequestParam(name = ConstantValues.DESCRIPTION, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String description) {
		ResponseBean responseBean = new ResponseBean();
		if (materialid == new Long(ConstantValues.DEFAULT_INT).longValue()
				|| description.equals(ConstantValues.DEFAULT_STRING)) {
			throw new NullRequestReceivedException(ConstantValues.RECEIVED_NULL_VALUES);
		} else {
			Materialcomposition materialcomposition = new Materialcomposition(materialid, description);
			materialcomposition = materialcompositionrepository.save(materialcomposition);
			if (materialcomposition.getMaterialid() == (materialid)) {
				responseBean.setMessage(ConstantValues.MATERIALCOMPOSITION_INSERTION_SUCCESS);
				responseBean.setResponsecode(SecurityHttpStatus.ACCEPTED);
				responseBean.setTiemstamp(System.currentTimeMillis());

				return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);
			}

			else {
				throw new DBInsertException(ConstantValues.MATERIALCOMPOSITION_INSERTION_HAS_ISSUE);
			}
		}
	}

	
	@PutMapping(path = URLMapping.MATERIALCOMPOSITION_MAPPING_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> update(
			@RequestParam(name = ConstantValues.MATERIAL_ID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long materialid,
			@RequestParam(name = ConstantValues.DESCRIPTION, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String description) 
	{
		Optional<Materialcomposition> materialcomposition = materialcompositionrepository.findById(materialid);
		if (materialcomposition.isPresent()) {
			materialcomposition.get().setMaterialid(materialid);
			materialcomposition.get().setDescription(description);
			Materialcomposition material = materialcompositionrepository.save(materialcomposition.get());
			
		if (material.getMaterialid() == materialid) {
			ResponseBean responseBean = new ResponseBean(ConstantValues.DATA_UPDATED_IN_DB, SecurityHttpStatus.ACCEPTED,
					System.currentTimeMillis());

			return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);
		} 
		else {
			throw new DBInsertException(ConstantValues.DATA_NOT_UPDATED_IN_DB);
		}
	}
		else {
			throw new MaterialcompositionException(ConstantValues.MATERIALCOMPOSITION_NOT_FOUND_WITH_GIVEN_ID);
		}
	}
	}
