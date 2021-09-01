package main.java.model;

import java.util.Objects;

public class OrderInfo {
    private int id;
    private int masterId;
    private double totalPrice;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderInfo)) return false;
        OrderInfo that = (OrderInfo) o;
        return id == that.id &&
                masterId == that.masterId &&
                Double.compare(that.totalPrice, totalPrice) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, masterId,totalPrice);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", masterid=" + masterId +
                ", price=" + totalPrice +
                '}';
    }
}
