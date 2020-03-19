/**
 * 
 */
package com.lc.sk.auth.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lc.sk.auth.entities.SecurityKeyManagement;
import com.lc.sk.auth.repositories.SecurityKeyManagementRepository;
import com.lc.sk.auth.bean.Key;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsAuthenticationService
 * 2020
 */
@Component
public class HeaderKeyManagement {

	@Autowired
	private SecurityKeyManagementRepository securityKeyManagement;
	
	private List<SecurityKeyManagement> keys = null;
	
	public Optional<SecurityKeyManagement> getKeysById(long id)
	{
		return securityKeyManagement.findById(id);
	}
	
	public List<SecurityKeyManagement> getAllKeys(){
		return (List<SecurityKeyManagement>) securityKeyManagement.findAll();
	}
	
	@SuppressWarnings("null")
	public Key getKey(String id)
	{
		Key key = new Key();
		keys = getAllKeys();
		if(id!=null || ! id.equals("")) {
			if(keys !=null ||keys.size()>0|| !keys.isEmpty()) {
				for(SecurityKeyManagement tkey: keys) {
					if(tkey.getKeyName().equals(id)) {
						key.setName(tkey.getKeyName());
						key.setValue(tkey.getKeyValue());
					}
				}
			}
		}
		
		return key;
	}
}
