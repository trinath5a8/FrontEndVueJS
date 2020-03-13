package com.lc.sk.inventory.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lc.sk.inventory.entities.Categories;

public interface CategoriesRepository  extends CrudRepository<Categories, Long> {

	
}
