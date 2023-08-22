package com.blog.service;

import com.blog.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INewsService extends IService<News>{
    void save(News news , int idCategory);
    List<News> findByCategoryId(int idCategory);

    Page<News> getAll(Pageable pageable);
}
