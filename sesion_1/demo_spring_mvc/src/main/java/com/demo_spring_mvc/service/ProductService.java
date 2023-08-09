package com.demo_spring_mvc.service;

import com.demo_spring_mvc.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
   private ArrayList<Product> products ;

    public ProductService() {
        products = new ArrayList<>();
        products.add(new Product(1,"egg",200,"https://songkhoemoingay.com/wp-content/uploads/2019/03/gai_xinh_vsbg-1.jpg"));
        products.add(new Product(2,"milk",300,"https://gamek.mediacdn.vn/133514250583805952/2021/12/18/photo-1-16398007477441311739914.jpg"));
        products.add(new Product(3,"noodle",500,"https://thptlevantamsoctrang.edu.vn/wp-content/uploads/2023/03/vsbg-5.jpg"));
    }
    public void add(Product product){
        products.add(product);
    }

    public List<Product> findAll(){
        return products;
    }
    public ArrayList<Product> getProducts() {
        return products;
    }
    public void delete(int id){
        int index = findIndexById(id);
        findAll().remove(index);
    }
    public int findIndexById(int id){
        for (int i = 0; i < findAll().size(); i++) {
            if (findAll().get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    public void edit(Product product){
        Product newProduct = findProductById(product.getId());
        newProduct.setImg(product.getImg());
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
    }
    public Product findProductById(int id){
        for (Product p: findAll() ) {
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }
    public List<Product> searchByName(String name){
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < findAll().size(); i++) {
            if (findAll().get(i).getName().toLowerCase().contains(name.toLowerCase())){
                productList.add(findAll().get(i));
            }
        }
        return productList;
    }
}
