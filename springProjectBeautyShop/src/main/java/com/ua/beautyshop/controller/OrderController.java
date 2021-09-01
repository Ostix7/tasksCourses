package com.ua.beautyshop.controller;

import com.ua.beautyshop.domain.Master;
import com.ua.beautyshop.domain.Order;
import com.ua.beautyshop.repository.OrderRepository;
import com.ua.beautyshop.service.MasterService;
import com.ua.beautyshop.service.OrderService;
import com.ua.beautyshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {


private final OrderService orderService;
private final UserService userService;
private final OrderRepository orderRepository;
    private final MasterService masterService;




    @Autowired
    public OrderController(OrderService orderService, UserService userService, OrderRepository orderRepository, MasterService masterService) {
        this.orderService = orderService;
        this.userService = userService;
        this.orderRepository = orderRepository;
        this.masterService = masterService;
    }

    @GetMapping("/orderListMaster")
    private String getOrderListMaster(Model model){
        List<Order> masterAllOrders=orderService.findAllByMaster(getMaster());
        List<Order> acceptedOrders=orderService.findAllByStatus(true);
        masterAllOrders.retainAll(acceptedOrders);
        model.addAttribute("masterorders",masterAllOrders);

        return "orderListMaster";
    }
    @GetMapping("/orderListMaster/done/{id}")
    private String getOrderListMasterDone(@PathVariable("id")long id){

        orderService.findById(id).setDone(true);
        orderService.save(orderRepository.findById(id));

        return "redirect:/orderListMaster";
    }

    @GetMapping("/orderListUser/comment/{id}")
    private String commentOrder(@PathVariable("id")long id,@RequestParam(value = "comment") String comment){

        orderService.findById(id).setComment(comment);
        orderService.save(orderRepository.findById(id));

        return "redirect:/orderListUser";
    }

    @GetMapping("/orderListAdmin")
    private String getOrderListAdmin(Model model) {
        model.addAttribute("masterorders",orderService.findAll());

        return "orderListAdmin";
    }

    @GetMapping("/orderListUser")
    private String getOrderListUser(Model model){

        model.addAttribute("masterorders",orderService.findAllByUserId(getUser()));
        model.addAttribute("status","In progress");
        return "orderListUser";
    }

    @GetMapping("/orderListAdmin/accept/{id}")
    private String acceptOrder(@PathVariable("id")long id,Model model){

        //TODO payment

        orderService.findById(id).setStatus(true);
        orderService.save(orderService.findById(id));
        model.addAttribute("masterorders",orderService.findAll());
        return "orderListAdmin";
    }






    @DeleteMapping("/orderListAdmin/decline")
        private String deleteOrder(@RequestParam(value = "Id") long id){
        orderRepository.delete(orderRepository.findById(id));
        return "redirect:/orderListAdmin";

    }



    public long getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return userService.findByUsername(username).getId();
    }
    public Master getMaster() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return masterService.findByUsername(username);
    }


}
