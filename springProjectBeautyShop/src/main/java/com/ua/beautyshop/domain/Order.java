package com.ua.beautyshop.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    @Column(name = "user_id")
    private @NotBlank long userId;


    @Column(name = "date")
    @NotNull(message = "Registration date required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate registrationDate;

    @Column(name = "time")
    @NotNull(message = "Estimated check in time required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime estimatedCheckInTime;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_id", nullable = true)
    private Master master;

    @Column(name="status")
    private boolean status=false;

    @Column(name = "done")
    private boolean done=false;

    @Column(name = "comment")
    private String comment;

    @Column(name="rate")
    @NotEmpty
    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("5.0")
    private double rate;

    public Order( long userId,LocalDate localDate,LocalTime localTime,BigDecimal totalPrice){
        this.userId = userId;
        this.registrationDate=localDate;
        this.estimatedCheckInTime=localTime;
        this.totalPrice=totalPrice;
    }

    public Order() {

    }


    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalTime getEstimatedCheckInTime() {
        return estimatedCheckInTime;
    }

    public void setEstimatedCheckInTime(LocalTime estimatedCheckInTime) {
        this.estimatedCheckInTime = estimatedCheckInTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    public boolean getStatus(){return status;}
    public void setStatus(boolean status){ this.status=status;}

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }



}



