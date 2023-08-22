package com.blog.repository;

import com.blog.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CategoryRepo extends PagingAndSortingRepository<Category, Integer> {

}
