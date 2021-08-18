package com.ua.beautyshop.service;

import com.ua.beautyshop.domain.Product;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ProductService {
    void save(Product product);
    void edit(long id, Product newProduct);
    void delete(long id);
    Product findById(long id);
    List<Product> findAll();
    List<Product> findAllByOrderByIdAsc();
    List<Product> findAllByCategoryId(long categoryId);
    long count();

}
