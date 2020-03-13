/**
 * 
 */
package com.lc.sk.inventory.config;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lc.sk.inventory.bean.Key;
import com.lc.sk.inventory.entities.SecurityKeyInventory;
import com.lc.sk.inventory.repositories.SecurityKeyInventoryRepository;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsInventoryService
 * 2020
 */
@Component
public class SecurityKeyInventoryComponent {

	@Autowired
	private SecurityKeyInventoryRepository securityKeyInventoryRepository;
	private List<SecurityKeyInventory> keys = null;
	
	public Optional<SecurityKeyInventory> getKeyById(long id)
	{
		return securityKeyInventoryRepository.findById(id);
	}
	
	public List<SecurityKeyInventory> getAllKeys(){
		return (List<SecurityKeyInventory>) securityKeyInventoryRepository.findAll();
	}
	
	@SuppressWarnings("null")
	public Key getKey(String id)
	{
		Key key = new Key();
		keys = getAllKeys();
		if(id!=null || ! id.equals("")) {
			if(keys !=null ||keys.size()>0|| !keys.isEmpty()) {
				for(SecurityKeyInventory tkey: keys) {
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
