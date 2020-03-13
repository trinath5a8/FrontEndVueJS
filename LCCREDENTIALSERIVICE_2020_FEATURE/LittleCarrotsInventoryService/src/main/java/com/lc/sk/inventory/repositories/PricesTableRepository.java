package com.lc.sk.inventory.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.lc.sk.inventory.entities.PricesTable;

public interface PricesTableRepository extends CrudRepository<PricesTable,Long> {
	 
	@Query( value ="select a.priceid,a.productid,a.mrp,a.lcprice,a.tax,a.sellingprice,a.finalprice from pricestable a WHERE a.productid=:productid", nativeQuery = true)
		PricesTable find(@Param("productid") Long productid);

}
