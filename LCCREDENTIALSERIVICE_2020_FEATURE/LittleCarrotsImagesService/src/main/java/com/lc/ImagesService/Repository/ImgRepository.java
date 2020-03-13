package com.lc.ImagesService.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lc.ImagesService.entity.ImagesEntity;



@Repository
public interface ImgRepository extends JpaRepository<ImagesEntity, Long>{

	 @Query( value ="select a.imgid,a.productid,a.imageurl from IMAGES a WHERE a.productid=:productid", nativeQuery = true)
	Iterable<ImagesEntity> find(@Param("productid") Long productid);
	 
}
