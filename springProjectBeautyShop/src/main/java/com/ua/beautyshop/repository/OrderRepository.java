package com.ua.beautyshop.repository;

import com.ua.beautyshop.domain.Master;
import com.ua.beautyshop.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAll();
    Order findById(long id);
    List<Order>findAllByUserId(long id);
    List<Order>findAllByStatus(boolean status);
    void deleteOrderById(long id);
    List<Order>findAllByMaster(Master master);
    List<Order>findAllByDone(boolean done);



}
