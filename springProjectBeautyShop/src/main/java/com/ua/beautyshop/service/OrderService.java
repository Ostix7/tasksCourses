package com.ua.beautyshop.service;

import com.ua.beautyshop.domain.Master;
import com.ua.beautyshop.domain.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {
    void save(Order order);
    void delete(long id);
    List<Order> findAll();
    Order findById(long id);
    List<Order>findAllByUserId(long id);
    List<Order>findAllByStatus(boolean status);
    void deleteOrderById(long id);
    List<Order>findAllByMaster(Master master);
    List<Order>findAllByDone(boolean done);

}
