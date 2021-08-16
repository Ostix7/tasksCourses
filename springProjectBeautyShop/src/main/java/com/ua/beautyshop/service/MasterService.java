package com.ua.beautyshop.service;

import com.ua.beautyshop.domain.Master;
import com.ua.beautyshop.domain.User;

public interface MasterService {

    void save(Master master);
    void login(String username, String password);
    Master findByUsername(String username);
    Master findById(long id);
}

