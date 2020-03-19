/**
 * 
 */
package com.lc.sk.auth.initializer;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsAuthenticationService
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
