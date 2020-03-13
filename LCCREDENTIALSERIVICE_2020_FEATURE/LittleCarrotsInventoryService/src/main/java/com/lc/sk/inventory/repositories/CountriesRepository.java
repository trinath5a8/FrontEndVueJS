/**
 * 
 */
package com.lc.sk.inventory.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lc.sk.inventory.entities.Countries;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsInventoryService
 * 2020
 */
public interface CountriesRepository extends CrudRepository<Countries, String> {

}
