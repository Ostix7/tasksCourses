package com.ua.beautyshop.repository;

import com.ua.beautyshop.domain.Master;
import com.ua.beautyshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasterRepository  extends JpaRepository<Master,Long> {
    Master findByUsername(String username);
    Master findById(long id);
    Master findByRate(double rate);
    List<Master> findAll();

}
