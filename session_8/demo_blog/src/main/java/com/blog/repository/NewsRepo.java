package com.blog.repository;

import com.blog.model.News;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsRepo extends PagingAndSortingRepository<News, Integer> {
    @Query(value = "select n from News n where n.category.id = :idCategory")
    List<News> getAllByCategory(@Param("idCategory") int idCategory);
}