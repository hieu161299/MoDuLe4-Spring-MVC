package com.jpa_repository.repository;

import com.jpa_repository.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends PagingAndSortingRepository<Product, Integer> {
    List<Product> findAllById(int id);

  /*  @Query(value = "select p from Product  p where p.name like concat('%' , :name , '%') ")
    List<Product> getAllByNameHQL(@Param("name")String name);*/

    @Query(value = "select p from Product  p where p.name like concat('%' , :name , '%') ")
    Page<Product> getAllByNameHQL(@Param("name")String name , Pageable pageable);

}
