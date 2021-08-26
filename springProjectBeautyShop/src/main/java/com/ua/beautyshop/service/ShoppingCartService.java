package com.ua.beautyshop.service;

import com.ua.beautyshop.domain.Order;
import com.ua.beautyshop.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

@Service
public interface ShoppingCartService {
    void addProduct(Product product);
    void removeProduct(Product product);
    void clearProducts();
    Map<Product, Integer> productsInCart();
    BigDecimal totalPrice();
    void cartCheckout(LocalDate localDate,LocalTime localTime);
    long getUser();
}
