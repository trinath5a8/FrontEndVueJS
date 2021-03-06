/**
 * 
 */
package com.lc.sk.auth.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lc.sk.auth.entities.SecurityKeyManagement;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsAuthenticationService
 * 2020
 */
public interface SecurityKeyManagementRepository extends CrudRepository<SecurityKeyManagement, Long> {

}
