package com.jpa_repository.service.impl;

import com.jpa_repository.model.Category;
import com.jpa_repository.model.Product;
import com.jpa_repository.repository.CategoryRepo;
import com.jpa_repository.repository.ProductRepo;
import com.jpa_repository.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ProductRepo productRepo;

    @Override
    public void save(Product product, int category_id) {
        Category category = categoryRepo.findById(category_id).get();
        product.setCategory(category);
        productRepo.save(product);
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    @Override
    public Page<Product> getAll(String name, Pageable pageable) {
        return productRepo.getAllByNameHQL(name , pageable);
    }

 /*   @Override
    public List<Product> getAllByName(String name) {
        return  productRepo.getAllByNameHQL(name);
    }*/

    @Override
    public List<Product> getAll() {
        return (List<Product>) productRepo.findAll();
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void edit(Product product) {
        productRepo.save(product);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product findById(int id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()){
            return optionalProduct.get();
        }else {
            return new Product();
        }

    }


}
