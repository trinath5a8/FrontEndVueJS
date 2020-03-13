package com.lc.sk.inventory.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lc.sk.inventory.entities.ProductQuantities;

public interface ProductQuantitiesRepository  extends CrudRepository <ProductQuantities, Long> {

}
