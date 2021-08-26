package com.ua.beautyshop.service.impl;

import com.ua.beautyshop.domain.Master;
import com.ua.beautyshop.domain.User;
import com.ua.beautyshop.repository.MasterRepository;
import com.ua.beautyshop.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class MasterDetailsServiceImpl implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(MasterDetailsServiceImpl.class);
    private final MasterRepository masterRepository;

    @Autowired
    public MasterDetailsServiceImpl(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    @Override
        @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username){
        Master master = masterRepository.findByUsername(username);


            Set<GrantedAuthority> authorities = new HashSet<>();

                authorities.add(new SimpleGrantedAuthority("ROLE_MASTER"));

            logger.debug(String.format("User with name: %s and password: %s created.", master.getUsername(), master.getPassword()));
            return new org.springframework.security.core.userdetails.User(master.getUsername(), master.getPassword(), authorities);

    }


}
