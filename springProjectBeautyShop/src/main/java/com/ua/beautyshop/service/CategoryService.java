package com.ua.beautyshop.service;

import com.ua.beautyshop.domain.Category;

import java.util.List;


public interface CategoryService {

    void save(Category category);
    List<Category> findAll();
}
