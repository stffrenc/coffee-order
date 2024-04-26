package edu.iu.stffrenc.coffeeorder.model;

import jakarta.persistence.*;

import java.util.*;
import java.lang.Math;

@Entity
@Table(schema = "coffee")
public final class OrderData {

    @Id
    private int orderId;
    private String beverage;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "order_condiments", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "condiment")
    private List<String> condiments;

    public OrderData() {}

    public OrderData(int orderId, String beverage, List<String> condiments) {
        this.orderId = orderId;
        this.beverage = beverage;
        this.condiments = condiments;
    }

    public <E> OrderData(String beverage, List<String> of) {
        this.orderId =(int)Math.random();
        this.beverage = beverage;
        this.condiments = of;

    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getBeverage() {
        return beverage;
    }

    public void setBeverage(String beverage) {
        this.beverage = beverage;
    }

    public List<String> getCondiments() {
        return condiments;
    }

    public void setCondiments(List<String> condiments) {
        this.condiments = condiments;
    }
}
