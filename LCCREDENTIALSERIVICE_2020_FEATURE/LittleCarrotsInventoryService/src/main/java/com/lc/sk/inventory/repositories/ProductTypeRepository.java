package com.lc.sk.inventory.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lc.sk.inventory.entities.ProductType;

public interface ProductTypeRepository extends CrudRepository<ProductType, Long> {

}
