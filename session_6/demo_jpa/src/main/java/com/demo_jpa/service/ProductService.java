package com.demo_jpa.service;

import com.demo_jpa.dao.ProductDAO;
import com.demo_jpa.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    public List<Product> getAll(){
        return productDAO.getAll();
    }
    public void add(Product product ){
        productDAO.add(product);
    }
    public void delete(Product product){
        productDAO.delete(product);
    }
    public void edit(Product product){
        productDAO.edit(product);
    }
    public Product findById(int id){
        return productDAO.findById(id);
    }
    public List<Product> findByName(String name){
        return  productDAO.findByName(name);
    }

    public List<Product> desc(){
        return productDAO.desc();
    }

}
