package com.jpa_repository.service;

import com.jpa_repository.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends IService<Product>{
    void save(Product product , int category_id );
    Page<Product> getAll(Pageable pageable);
   /* List<Product> getAllByName(String name );*/

    Page<Product> getAll(String name , Pageable pageable);
}
