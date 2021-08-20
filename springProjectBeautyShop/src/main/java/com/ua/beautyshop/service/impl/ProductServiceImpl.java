package com.ua.beautyshop.service.impl;

import com.ua.beautyshop.domain.Product;
import com.ua.beautyshop.repository.MasterRepository;
import com.ua.beautyshop.repository.ProductRepository;
import com.ua.beautyshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final MasterRepository masterRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,MasterRepository masterRepository){
        this.productRepository = productRepository;
        this.masterRepository=masterRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void edit(long id, Product newProduct) {
        Product found = productRepository.getOne(id);
        found.setName(newProduct.getName());
        found.setImageUrl(newProduct.getImageUrl());
        found.setDescription(newProduct.getDescription());
        found.setPrice(newProduct.getPrice());
        save(newProduct);
    }

    @Override
    public void delete(long id) {
        productRepository.delete(findById(id));
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findAll() {
       return productRepository.findAll();
    }

    @Override
    public List<Product> findAllByMaster(long id) {
        List <Product> temp;
         temp=productRepository.findAll().stream().filter(product -> (product.getMaster().getId())==masterRepository.findById(id).getId()).collect(Collectors.toList());
        return temp;
    }

    @Override
    public List<Product> findAllByOrderByIdAsc() {
        return productRepository.findAllByOrderByIdAsc();
    }

    @Override
    public List<Product> findAllByCategoryId(long categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }

    @Override
    public long count() {
        return productRepository.count();
    }


}
