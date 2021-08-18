package com.ua.beautyshop.service.impl;

import com.ua.beautyshop.domain.Master;
import com.ua.beautyshop.repository.MasterRepository;
import com.ua.beautyshop.repository.UserRepository;
import com.ua.beautyshop.service.MasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
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
    private final BCryptPasswordEncoder bCryptPasswordEncoderMaster;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService masterDetailsService;
    private static final Logger logger = LoggerFactory.getLogger(MasterServiceImpl.class);



    @Autowired
    public MasterServiceImpl(MasterRepository masterRepository, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService masterDetailsService, AuthenticationManager authenticationManager) {
        this.masterRepository = masterRepository;
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
    public List<Master> findAll() {
        return masterRepository.findAll();
    }
}
