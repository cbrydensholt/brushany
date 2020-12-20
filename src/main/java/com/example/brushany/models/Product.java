package com.example.brushany.models;

public class Product {
    private int id;
    String name;
    String producer;
    double price;
    String date;
    boolean active;

    public Product(int id, String name, String producer, double price, String date, boolean active) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.date = date;
        this.active = active;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
