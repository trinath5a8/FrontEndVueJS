/**
 * 
 */
package com.lc.sk.inventory.security.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lc.sk.inventory.security.beans.Key;
import com.lc.sk.inventory.security.entities.SecurityKeyManagement;
import com.lc.sk.inventory.security.repositories.SecurityKeyManagementRepository;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsInventorySecurityService
 * 2020
 */

@Component
public class HeaderKeyManagement {

	@Autowired
	private SecurityKeyManagementRepository securityKeyManagementRepository;
	private List<SecurityKeyManagement> keys = null;
	
	public Optional<SecurityKeyManagement> getKeysById(long id)
	{
		return securityKeyManagementRepository.findById(id);
	}
	
	public List<SecurityKeyManagement> getAllKeys(){
		return (List<SecurityKeyManagement>) securityKeyManagementRepository.findAll();
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
