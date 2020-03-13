/**
 * 
 */
package com.lc.sk.inventory.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lc.sk.inventory.entities.Batch;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsInventoryService
 * 2020
 */
public interface BatchRepository extends CrudRepository<Batch, Long> {

}
