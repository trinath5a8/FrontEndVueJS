/**
 * 
 */
package com.lc.sk.inventory.security.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import com.lc.sk.inventory.security.beans.ErrorBean;
import com.lc.sk.inventory.security.beans.UrlBean;
import com.lc.sk.inventory.security.entities.ServiceURLs;
import com.lc.sk.inventory.security.repositories.ServiceUrlRepository;

/**
 * @author Mastanvali Shaik LittleCarrotsInventorySecurityService 2020
 */

@Component
public class ServiceUrlsDao {

	@Autowired
	ServiceUrlRepository serviceUrlRepository;

	public UrlBean getAccessUrl(String urlid) {
		Optional<ServiceURLs> serviceUrl = serviceUrlRepository.findById(urlid);

		if (serviceUrl.isPresent()) {
			return new UrlBean(serviceUrl.get().getServiceip(), serviceUrl.get().getUrl(), serviceUrl.get().getMethod(),
					serviceUrl.get().getTimeout(), serviceUrl.get().getServicename());
		} else {
			return getErrorBean();
		}

	}

	public UrlBean getErrorBean() {
		return new ErrorBean("localhost", "/error", HttpMethod.GET.toString(), 1000, "error");
	}

}
