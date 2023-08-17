package com.demo_jpa.dao;

import com.demo_jpa.model.Product;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ProductDAO {
    @PersistenceContext
    EntityManager entityManager;
    public List<Product> getAll(){
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    public void add(Product product){
        entityManager.persist(product);
    }

    public void edit(Product product){
        entityManager.merge(product);
    }

    public void delete(Product product){
       // entityManager.remove(product);
     //   entityManager.remove(entityManager.contains(product) ? product : entityManager.merge(product));
        Query query = entityManager.createQuery("delete from Product where id = " + product.getId());
        query.executeUpdate();
    }

    public Product findById(int id){
        return entityManager.find(Product.class,id);
    }

    public List<Product> findByName(String name){
        List<Product> products = new ArrayList<>();
        for (Product p: getAll()) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())){
                products.add(p);
            }
        }
        return products;
    }
    public List<Product> desc(){
       return entityManager.createQuery("from Product p order by p.price desc " , Product.class).getResultList();
    }

}
