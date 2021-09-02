package com.ua.beautyshop.service.impl;

import com.ua.beautyshop.domain.Master;
import com.ua.beautyshop.domain.Order;
import com.ua.beautyshop.repository.MasterRepository;
import com.ua.beautyshop.service.MasterService;
import com.ua.beautyshop.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterServiceImpl implements MasterService {
    private final MasterRepository masterRepository;
    private final OrderService orderService;
    private final BCryptPasswordEncoder bCryptPasswordEncoderMaster;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService masterDetailsService;
    private static final Logger logger = LoggerFactory.getLogger(MasterServiceImpl.class);



    @Autowired
    public MasterServiceImpl(MasterRepository masterRepository, OrderService orderService, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService masterDetailsService, AuthenticationManager authenticationManager) {
        this.masterRepository = masterRepository;
        this.orderService = orderService;
        this.bCryptPasswordEncoderMaster = bCryptPasswordEncoder;
        this.masterDetailsService = masterDetailsService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void save(Master master) {
        master.setPassword(bCryptPasswordEncoderMaster.encode(master.getPassword()));
        masterRepository.save(master);
    }

    @Override
    public void login(String username, String password) {
        UserDetails masteruserDetails = masterDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(masteruserDetails, password, masteruserDetails.getAuthorities());
        authenticationManager.authenticate(token);

        if (token.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(token);
            logger.debug(String.format("User %s logged in successfully!", username));
        }else{
            logger.error(String.format("Error with %s authentication!", username));
        }
    }


    @Override
    public Master findByUsername(String username) {
        return masterRepository.findByUsername(username);
    }


    @Override
    public Master findById(long id) {
        return masterRepository.findById(id);
    }

    @Override
    public Master findByRate(double rate) {
        return masterRepository.findByRate(rate);
    }






    @Override
    public List<Master> findAll() {
        return masterRepository.findAll();
    }

    @Override
    public double setRate(Master master) {
        return calculateRate(master);
    }

    private  double calculateRate(Master master){
        double rate=3.0;

        List<Order> list=orderService.findAllByMaster(master);
        for (Order order:list) {
            rate+=order.getRate();
        }
        if(orderService.findAllByMaster(master).size()==0)
            return 3.0;

        return rate/orderService.findAllByMaster(master).size();
    }


//    @Override
//    public List<Master> findAllByUsername() {
//        return masterRepository.findAllByUsername();
//    }
}
