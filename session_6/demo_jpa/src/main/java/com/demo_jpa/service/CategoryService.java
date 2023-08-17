package com.demo_jpa.service;

import com.demo_jpa.dao.CategoryDAO;
import com.demo_jpa.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    CategoryDAO categoryDAO;

    public CategoryService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }
    public List<Category> getAll(){
        return categoryDAO.getAll();
    }
    public Category findById(int id){
        return categoryDAO.findByID(id);
    }
}
