package com.ua.beautyshop.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@Table(name = "master")
public class Master {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name="username")
    @NotEmpty
    @NotNull
    private String username;

    @NotEmpty
    @NotNull
    private String password;

    @NotEmpty
    @NotNull
    private String passwordConfirm;

    @Column(name = "image")
    private String imageUrl;


    @Column(name="rate")
    @NotEmpty
    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("5.0")
    private double rate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;

        return id == product.getId();
    }

}
