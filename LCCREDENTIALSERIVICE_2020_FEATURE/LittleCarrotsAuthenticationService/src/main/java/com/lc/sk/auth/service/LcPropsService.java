/**
 * 
 */
package com.lc.sk.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lc.sk.auth.dao.LcPropsDao;
import com.lc.sk.auth.entities.Lcprops;
import com.lc.sk.auth.util.URLMapping;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsAuthenticationService
 * 2020
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Validated
@RequestMapping(path = URLMapping.LC_PATH)
public class LcPropsService {

	@Autowired
	private LcPropsDao lcpropdao;
	
	/*
	public ResponseEntity<List<Lcprops>> getAllProperties(){
		
	}
	*/
}
