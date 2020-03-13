package com.lc.sk.inventory.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lc.sk.inventory.entities.Products;

public interface ProductsRepository extends CrudRepository<Products, Long> {




}
