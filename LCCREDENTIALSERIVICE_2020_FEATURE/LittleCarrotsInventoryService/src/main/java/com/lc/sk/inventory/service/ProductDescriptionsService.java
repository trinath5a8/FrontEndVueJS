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
import com.lc.sk.inventory.entities.ProductDescriptions;
import com.lc.sk.inventory.exception.subexception.DBInsertException;
import com.lc.sk.inventory.exception.subexception.ProductDescriptionsNotFoundException;
import com.lc.sk.inventory.repositories.ProductDescriptionsRepository;
import com.lc.sk.inventory.util.ConstantValues;
import com.lc.sk.inventory.util.HeaderComponent;
import com.lc.sk.inventory.util.SecurityHttpStatus;
import com.lc.sk.inventory.util.URLMapping;



@RestController
@Validated
@RequestMapping(path=URLMapping.INVENTORY_ROOT_PATH)

public class ProductDescriptionsService {

	@Autowired
	ProductDescriptionsRepository productdescriptionrepository;
	
	@Autowired
	HeaderComponent hearders;
	
	public ProductDescriptionsService() {
		
	}
	
	
	
	//Get all ProductDescriptions
	@GetMapping (path = URLMapping.PRODUCTDESCRIPTIONS_PATH)
	@ResponseBody
	public ResponseEntity<List<ProductDescriptions>> getAllProductDescriptions(){
		List<ProductDescriptions> productdescriptions= (List<ProductDescriptions>)productdescriptionrepository.findAll();
		if(productdescriptions.isEmpty()) {
			throw new ProductDescriptionsNotFoundException(ConstantValues.NO_PRODUCTDESCRIPTIONS_LIST_FOUND);
		}
		else {
			return new ResponseEntity<List<ProductDescriptions>>(productdescriptions,hearders.getHeader(),HttpStatus.ACCEPTED);
		}
	}
	
	//Get by id
	@GetMapping(path=URLMapping.PRODUCTDESCRIPTIONS_PATH_WITH_ID)
	@ResponseBody
	public ResponseEntity<Optional<ProductDescriptions>> getDescriptionsid(@PathVariable long  descriptionid)
	{
		Optional<ProductDescriptions> productdescriptions = productdescriptionrepository.findById(descriptionid);
		if(productdescriptions.isPresent())
		{
			return new ResponseEntity<Optional<ProductDescriptions>>(productdescriptions, hearders.getHeader(), HttpStatus.ACCEPTED);
		}
		else
		{
			throw new ProductDescriptionsNotFoundException(ConstantValues.NO_PRODUCTDESCRIPTIONS_LIST_FOUND);
		}
	}
	
	//Insertion
	@PostMapping (path = URLMapping.PRODUCTDESCRIPTIONS_PATH)
	@ResponseBody
	public ResponseEntity<ResponseBean> addList(
			@RequestParam(name=ConstantValues.DESCRIPTION,required=true,defaultValue=ConstantValues.DEFAULT_STRING)String description){
		ResponseBean responseBean=new ResponseBean();
		ProductDescriptions productdescriptions=productdescriptionrepository.save(new ProductDescriptions(description));
		if(productdescriptions.getDescription().equals(description))
		{
			responseBean.setMessage(ConstantValues.DATA_INSERTED_IN_DB);
			responseBean.setResponsecode(SecurityHttpStatus.ACCEPTED);
			responseBean.setTiemstamp(System.currentTimeMillis());
			return new ResponseEntity<ResponseBean>(responseBean,hearders.getHeader(),HttpStatus.ACCEPTED);
		}
		else
		{
			throw new DBInsertException(ConstantValues.DATA_NOT_INSERTED_IN_DB);
		}
	}
	
	//update
		@PutMapping (path=URLMapping.PRODUCTDESCRIPTIONS_PATH)
		@ResponseBody
		public ResponseEntity<ResponseBean> update(
				@RequestParam(name=ConstantValues.DESCRIPTIONID,required=true,defaultValue=ConstantValues.DEFAULT_INT)long descriptionid,
				@RequestParam(name=ConstantValues.DESCRIPTION,required=true,defaultValue=ConstantValues.DEFAULT_STRING)String description){
			Optional<ProductDescriptions> productdescriptionsget = productdescriptionrepository.findById(descriptionid);
			if(productdescriptionsget.isPresent())
			{
				productdescriptionsget.get().setDescriptionid(descriptionid);
				productdescriptionsget.get().setDescription(description);
				ProductDescriptions productdescriptionsupdate=productdescriptionrepository.save(productdescriptionsget.get());
				if (productdescriptionsupdate.getDescriptionid() == descriptionid)
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
					throw new ProductDescriptionsNotFoundException(ConstantValues.DESCRIPTIONID_NOT_FOUND);
				}
				
			}
			
			
		

	}