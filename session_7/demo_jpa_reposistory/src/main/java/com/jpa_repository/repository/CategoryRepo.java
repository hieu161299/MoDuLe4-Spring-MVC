package com.jpa_repository.repository;

import com.jpa_repository.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepo extends PagingAndSortingRepository<Category,Integer> {
}
