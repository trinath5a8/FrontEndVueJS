package com.lc.sk.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.lc.sk.inventory.bean.ResponseBean;

import com.lc.sk.inventory.entities.Patterns;

import com.lc.sk.inventory.exception.subexception.DBInsertException;
import com.lc.sk.inventory.exception.subexception.NullRequestReceivedException;
import com.lc.sk.inventory.exception.subexception.PatternsNotFoundException;
import com.lc.sk.inventory.repositories.PatternsRepository;
import com.lc.sk.inventory.util.ConstantValues;
import com.lc.sk.inventory.util.HeaderComponent;
import com.lc.sk.inventory.util.SecurityHttpStatus;
import com.lc.sk.inventory.util.URLMapping;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(path=URLMapping.INVENTORY_ROOT_PATH)
public class PatternsService {


	@Autowired
	PatternsRepository patternsRepository;
	
	@Autowired
	HeaderComponent hearders;

	public PatternsService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
		
		/* Get all patterns list */
		@GetMapping(path = URLMapping.PATTERNS_PATH)
		@ResponseBody
		public ResponseEntity<List<Patterns>> getAllPatternsDetails() {
			List<Patterns> getpatterns = (List<Patterns>) patternsRepository.findAll();
			if (getpatterns.isEmpty()) {
				throw new PatternsNotFoundException(ConstantValues.NO_PATTERNS_LIST_FOUND);
			} else {
				return new ResponseEntity<List<Patterns>>(getpatterns, hearders.getHeader(), HttpStatus.ACCEPTED);		
			}
		}
		
		/* patterns details by patid */
		@GetMapping(path = URLMapping.PATTERNS_PATH_WITH_ID)
		@ResponseBody
		public ResponseEntity<Optional<Patterns>> getById(@PathVariable long patid) {
			Optional<Patterns> getpatternsid = patternsRepository.findById(patid);
			if (!getpatternsid.isPresent()||getpatternsid.get() == null) {
				throw new PatternsNotFoundException(ConstantValues.NO_PATTERNS_LIST_FOUND);
			} else {
				return new ResponseEntity<Optional<Patterns>>(getpatternsid, hearders.getHeader(), HttpStatus.ACCEPTED);
			}
		}
		
		
		
		
		//insertion 
		@PostMapping(path = URLMapping.PATTERNS_PATH)
		@ResponseBody	
		public ResponseEntity<ResponseBean> addList(
				@RequestParam(name = ConstantValues.DESCRIPTION, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String description,
				@RequestParam(name = ConstantValues.PRODUCTID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long productid) {
			ResponseBean responseBean = new ResponseBean();
		
			if( description.equals(ConstantValues.DEFAULT_STRING)||	productid==new Long(ConstantValues.DEFAULT_INT).longValue()) {
				throw new NullRequestReceivedException(ConstantValues.RECEIVED_NULL_VALUES);
		} else {				
			Patterns postpatterns=patternsRepository.save(new Patterns(description,productid));
			
			if(postpatterns.getDescription().equals(description))
			{
				responseBean.setMessage(ConstantValues.DATA_INSERTED_IN_DB);
				responseBean.setResponsecode(SecurityHttpStatus.ACCEPTED);
				responseBean.setTiemstamp(System.currentTimeMillis());
				return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);
			} else {
				throw new DBInsertException(ConstantValues.DATA_NOT_INSERTED_IN_DB);
			}
		}
		}
				
		

		//update
				@PutMapping(path=URLMapping.PATTERNS_PATH)
				@ResponseBody
				public ResponseEntity<ResponseBean> update(
						@RequestParam(name = ConstantValues.PATID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long patid,
						@RequestParam(name = ConstantValues.DESCRIPTION, required = true, defaultValue = ConstantValues.DEFAULT_STRING) String description,
						@RequestParam(name = ConstantValues.PRODUCTID, required = true, defaultValue = ConstantValues.DEFAULT_INT) long productid){
					
					Optional<Patterns> getpatterns = patternsRepository.findById(patid);
					 if(getpatterns.isPresent())
					  {
						 getpatterns.get().setDescription(description);						 
						 getpatterns.get().setProductid(productid);
						 
						  Patterns updatepatterns=patternsRepository.save(getpatterns.get());
						  
						  if (updatepatterns.getPatid() == patid)
						  {
								ResponseBean responseBean = new ResponseBean(ConstantValues.DATA_UPDATED_IN_DB,SecurityHttpStatus.ACCEPTED, System.currentTimeMillis());
								return new ResponseEntity<ResponseBean>(responseBean, hearders.getHeader(), HttpStatus.ACCEPTED);
							}
						  else 
						  {
								throw new DBInsertException(ConstantValues.DATA_NOT_UPDATED_IN_DB);
						  }  
					  }
					  else
						{
						  throw new PatternsNotFoundException(ConstantValues.NO_PATTERNS_LIST_FOUND);
						}
				}
	
			
			
		
		
}
