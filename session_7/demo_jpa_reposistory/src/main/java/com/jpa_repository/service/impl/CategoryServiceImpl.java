package com.jpa_repository.service.impl;

import com.jpa_repository.model.Category;
import com.jpa_repository.repository.CategoryRepo;
import com.jpa_repository.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public List<Category> getAll() {
        return (List<Category>) categoryRepo.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void edit(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Category findById(int id) {
        return (Category) categoryRepo.findById(id).get();
    }
}
