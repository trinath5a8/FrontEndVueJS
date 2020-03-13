package com.lc.sk.inventory.security.factory;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;

/**
 * 
 */

/**
 * @author Mastanvali Shaik
 * LittleCarrotsInventorySecurityService
 * 2020
 */
@Component
public class ServiceHttpRequestFactory {

	public ClientHttpRequestFactory getClientHttpRequestFactory(long timeout) {
	    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
	      = new HttpComponentsClientHttpRequestFactory();
	    clientHttpRequestFactory.setConnectTimeout((int)timeout);
	    return clientHttpRequestFactory;
	}
}
