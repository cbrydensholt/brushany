package com.example.brushany.models;


import java.sql.Time;
import java.util.Date;

public class Subscription {

    private Long id;
    String startDate;
    int subscriptionType;
    int customerId;
    int productId;
    String active;

    public Subscription() {
    }

    public Subscription(Long id, String startDate, int subscriptionType, int customerId, int productId, String active) {
        this.id = id;
        this.startDate = startDate;
        this.subscriptionType = subscriptionType;
        this.customerId = customerId;
        this.productId = productId;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(int subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
