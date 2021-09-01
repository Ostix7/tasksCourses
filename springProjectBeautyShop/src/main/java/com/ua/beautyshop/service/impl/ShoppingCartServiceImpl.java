package com.ua.beautyshop.service.impl;

import com.ua.beautyshop.domain.Master;
import com.ua.beautyshop.domain.Order;
import com.ua.beautyshop.domain.Product;
import com.ua.beautyshop.domain.User;
import com.ua.beautyshop.repository.OrderRepository;
import com.ua.beautyshop.service.OrderService;
import com.ua.beautyshop.service.ShoppingCartService;
import com.ua.beautyshop.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;



@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private Map<Product, Integer> cart = new LinkedHashMap<>();
    private final OrderService orderService;
    private final UserService userService;
    private static Master master;

    public ShoppingCartServiceImpl(OrderService orderService,UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @Override
    public void addProduct(Product product) {
        master=product.getMaster();
        if (cart.containsKey(product)){
            cart.replace(product, cart.get(product) + 1);
        }else{
            cart.put(product, 1);
        }
    }

    @Override
    public void removeProduct(Product product) {
        if (cart.containsKey(product)) {
            if (cart.get(product) > 1)
                cart.replace(product, cart.get(product) - 1);
            else if (cart.get(product) == 1) {
                cart.remove(product);
            }
        }
    }

    @Override
    public void clearProducts() {
        cart.clear();
    }

    @Override
    public Map<Product, Integer> productsInCart() {
        return Collections.unmodifiableMap(cart);
    }

    @Override
    public BigDecimal totalPrice() {
        return cart.entrySet().stream()
                .map(k -> k.getKey().getPrice().multiply(BigDecimal.valueOf(k.getValue()))).sorted()
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    @Override
    public void cartCheckout(LocalDate localDate,LocalTime localTime) {
        Order order=new Order(getUser(),localDate,localTime,totalPrice());
        order.setMaster(master);
        BigDecimal balance = userService.findById(getUser()).getBalance();
        if(balance.compareTo(totalPrice())==1){
            orderService.save(order);
            userService.findById(getUser()).setBalance((balance.subtract(totalPrice())));
            cart.clear();
        }


    }

    @Override
    public long getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return userService.findByUsername(username).getId();
    }



//    private ISpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
//        SpringTemplateEngine engine = new SpringTemplateEngine();
//        engine.addDialect(new Java8TimeDialect());
//        engine.setTemplateResolver(templateResolver);
//        return engine;
//    }
}
