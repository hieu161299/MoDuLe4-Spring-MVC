package com.blog.service.impl;

import com.blog.model.Category;
import com.blog.model.News;
import com.blog.repository.CategoryRepo;
import com.blog.repository.NewsRepo;
import com.blog.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsServiceImpl implements INewsService {
    @Autowired
    NewsRepo newsRepo;
    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public void save(News news, int idCategory) {
        Category category = categoryRepo.findById(idCategory).get();
        news.setCategory(category);
        newsRepo.save(news);
    }

    @Override
    public List<News> findAll() {
        return (List<News>) newsRepo.findAll();
    }

    public Page<News> getAll(Pageable pageable){
        return newsRepo.findAll(pageable);
    }

    @Override
    public void add(News news) {

    }

    @Override
    public void edit(News news) {
        newsRepo.save(news);
    }

    @Override
    public void delete(int id) {
        News news = newsRepo.findById(id).get();
        newsRepo.delete(news);
    }

    @Override
    public News findById(int id) {
        return newsRepo.findById(id).get();
    }
    public List<News> findByCategoryId(int idCategory) {
        return newsRepo.getAllByCategory(idCategory);
    }
}
