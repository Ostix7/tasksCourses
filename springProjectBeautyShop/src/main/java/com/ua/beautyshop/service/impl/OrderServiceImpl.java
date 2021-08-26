package com.ua.beautyshop.service.impl;

import com.ua.beautyshop.domain.Master;
import com.ua.beautyshop.domain.Order;
import com.ua.beautyshop.domain.Product;
import com.ua.beautyshop.repository.OrderRepository;
import com.ua.beautyshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void delete(long id) {
orderRepository.delete(findById(id));
    }

    @Override
    public Order findById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findAllByUserId(long id) {
        return orderRepository.findAllByUserId(id);
    }

    @Override
    public List<Order> findAllByStatus(boolean status) {
        return orderRepository.findAllByStatus(status);
    }

    @Override
    public void deleteOrderById(long id) {
         orderRepository.deleteOrderById(id);
    }

    @Override
    public List<Order> findAllByMaster(Master master) {
        return orderRepository.findAllByMaster(master);
    }

    @Override
    public List<Order> findAllByDone(boolean done) {
        return orderRepository.findAllByDone(done);
    }


    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
