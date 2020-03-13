/**
 * 
 */
package com.lc.sk.inventory.security.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lc.sk.inventory.security.entities.ServiceURLs;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsInventorySecurityService
 * 2020
 */
@RepositoryRestResource
public interface ServiceUrlRepository extends CrudRepository<ServiceURLs, String>{

}
