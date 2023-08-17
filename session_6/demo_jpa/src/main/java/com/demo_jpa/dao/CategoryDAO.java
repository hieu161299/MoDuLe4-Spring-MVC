package com.demo_jpa.dao;

import com.demo_jpa.model.Category;
import com.demo_jpa.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDAO {
    @PersistenceContext
    EntityManager entityManager;

    public List<Category> getAll(){
        return entityManager.createQuery("from Category " , Category.class).getResultList();
    }
    public Category findByID(int id){

        return entityManager.find(Category.class , id);
    }

}
