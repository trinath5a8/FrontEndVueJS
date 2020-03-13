/**
 * 
 */
package com.lc.sk.auth.config;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lc.sk.auth.entities.SecurityKeyManagement;
import com.lc.sk.auth.rbeans.KeyBean;
import com.lc.sk.auth.repositories.SecurityKeyManagementRepository;

/**
 * @author Mastanvali Shaik LittleCarrotsAuthenticationService 2020
 */
@Component
public class KeyManagementComponent {

	@Autowired
	private SecurityKeyManagementRepository securityKeyManagementRepository;

	public List<SecurityKeyManagement> getAllKeys() {
		List<SecurityKeyManagement> keys = (List<SecurityKeyManagement>) securityKeyManagementRepository.findAll();
		return keys;
	}

	public Optional<SecurityKeyManagement> getByKeyId(long id) {
		Optional<SecurityKeyManagement> key = securityKeyManagementRepository.findById(id);
		return key;
	}

	@SuppressWarnings("null")
	public KeyBean getKey(long id) {
		KeyBean headerData = new KeyBean();
		SecurityKeyManagement key = getByKeyId(id).get();
		if (key != null || key.getKeyId() != 0) {
			headerData.setName(key.getKeyName());
			headerData.setValue(key.getKeyValue());
		} else {
			headerData.setName("null");
			headerData.setValue("null");
		}
		return headerData;
	}
}
