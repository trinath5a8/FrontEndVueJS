/**
 * 
 */
package com.lc.sk.auth.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lc.sk.auth.entities.Lcprops;
import com.lc.sk.auth.rbeans.ResponseBean;
import com.lc.sk.auth.repositories.LcpropsRepository;
import com.lc.sk.auth.util.SecurityHttpStatus;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsAuthenticationService
 * 2020
 */
@Component
public class LcPropsDao {

	@Autowired
	private LcpropsRepository lcprops;
	
	public List<Lcprops> getAll(){
		return (List<Lcprops>) lcprops.findAll();
	}
	
	public Optional<Lcprops> getById(long id){
		return lcprops.findById(id);
	}
	
	public ResponseBean updateStatus(long id, boolean status) {
		ResponseBean responseBean = null;
		Optional<Lcprops> lcprop = lcprops.findById(id);
		if(lcprop.isPresent()) {
			if(lcprop.get().getPropid() == id) {
				lcprop.get().setStatus(status);
				Lcprops temp = lcprops.save(lcprop.get());
				if(temp.getPropid()== id && temp.isStatus()== status) {
					responseBean = new ResponseBean("Property Status Update Sucess", SecurityHttpStatus.ACCEPTED, System.currentTimeMillis());
				}else
				{
					responseBean = new ResponseBean("Property Status Update Fail", SecurityHttpStatus.NOT_FOUND, System.currentTimeMillis());
				}
			}else {
				responseBean = new ResponseBean("Invalid Property Id",  SecurityHttpStatus.NOT_FOUND, System.currentTimeMillis());
			}
		}else {
			responseBean = new ResponseBean("Invalid Property Id",  SecurityHttpStatus.NOT_FOUND, System.currentTimeMillis());
		}
		return responseBean;
	}
	
	public Lcprops getByProp(String prop) {
		Lcprops lc = null;
		List<Lcprops> lcs = getAll();
		if(!lcs.isEmpty()) {
			for(Lcprops temp: lcs) {
				if(temp.getProp()!=null&&!temp.getProp().equals("")&&temp.getProp().equals(prop)) {
					lc = temp;
				}
			}
		}
		return lc;
	}
	
	public boolean getPropStatus(String prop) {
		return getByProp(prop).isStatus();
	}
}
