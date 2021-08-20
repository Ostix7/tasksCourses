package com.ua.beautyshop.repository;

import com.ua.beautyshop.domain.Master;
import com.ua.beautyshop.domain.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.OrderBy;
import java.util.List;

@Repository
public interface MasterRepository  extends JpaRepository<Master,Long> {
    Master findByUsername(String username);
    Master findById(long id);
    Master findByRate(double rate);
    List<Master> findAll();


}
