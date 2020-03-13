/**
 * 
 */
package com.lc.sk.auth.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lc.sk.auth.entities.AuthorizedUsers;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsAuthenticationService
 * 2020
 */
public interface AuthorizedUsersRepository extends CrudRepository<AuthorizedUsers, String> {

	
	
}
