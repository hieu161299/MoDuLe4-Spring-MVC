package com.blog.service;

import java.util.List;

public interface IService<E> {
    List<E> findAll();
    void add(E e);
    void edit(E e);
    void delete(int id);
    E findById(int id);
}
