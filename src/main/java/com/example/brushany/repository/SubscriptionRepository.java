package com.example.brushany.repository;


import com.example.brushany.models.Subscription;
import com.example.brushany.util.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class SubscriptionRepository {

    private Connection conn;
    public SubscriptionRepository() {this.conn = DatabaseConnectionManager.getDatabaseConnection();}
/*
    int customerId;
    String name;
    String email;
    int phone;
    String address;
    String cpr;
  */

    public void create(Subscription subscription) {
        try {
            PreparedStatement createCustomer = conn.prepareStatement("INSERT INTO subscription(startDate, subscriptionType, customerId, productId, active)" + "VALUES(?,?,?,?,?) ");
            createCustomer.setString(1, subscription.getStartDate());
            createCustomer.setInt(2, subscription.getSubscriptionType());
            createCustomer.setInt(3, subscription.getCustomerId());
            createCustomer.setInt(4, subscription.getProductId());
            createCustomer.setString(5, subscription.getActive());
            createCustomer.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Subscription> readAll() {
        ArrayList<Subscription> allSubscriptions = new ArrayList<>();
        try{
            PreparedStatement readAllSubs = conn.prepareStatement("SELECT id, startDate, subscriptionType, customerId, productId, active FROM subscription");
            ResultSet rs = readAllSubs.executeQuery();
            while(rs.next()){
                Subscription subscription = new Subscription();
                subscription.setId(rs.getLong(1));
                subscription.setStartDate(rs.getString(2));
                subscription.setSubscriptionType(rs.getInt(3));
                subscription.setCustomerId(rs.getInt(4));
                subscription.setProductId(rs.getInt(5));
                subscription.setActive(rs.getString(6));

                allSubscriptions.add(subscription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allSubscriptions;


    }

    public Subscription readSingleSubscription(int subscriptionId) {
        Subscription tempSubscription = new Subscription();
        try{
            PreparedStatement readtemp = conn.prepareStatement("SELECT * from subscription WHERE id = ?");
            readtemp.setInt(1, subscriptionId);
            ResultSet rs = readtemp.executeQuery();
            while(rs.next()){
                tempSubscription = new Subscription();
                tempSubscription.setId(rs.getLong(1));
                tempSubscription.setStartDate(rs.getString(2));
                tempSubscription.setSubscriptionType(rs.getInt(3));
                tempSubscription.setCustomerId(rs.getInt(4));
                tempSubscription.setProductId(rs.getInt(5));
                tempSubscription.setActive(rs.getString(6));


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return tempSubscription;
    }



    public boolean update(Subscription subscription) {

        try{
            PreparedStatement updatesubscription = conn.prepareStatement("UPDATE subscription SET startDate=?, subscriptionType=?, customerId=?, productId=?, active=? WHERE id =?");
            updatesubscription.setString(1, subscription.getStartDate());
            updatesubscription.setInt(2, subscription.getSubscriptionType());
            updatesubscription.setInt(3, subscription.getCustomerId());
            updatesubscription.setInt(4, subscription.getProductId());
            updatesubscription.setString(5, subscription.getActive());
            updatesubscription.setLong(6, subscription.getId());
            updatesubscription.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }



    public boolean delete(int subscriptionId) {
        try {
            PreparedStatement deleteSub = conn.prepareStatement("DELETE FROM subscription WHERE id = ?");
            deleteSub.setLong(1, subscriptionId);
            deleteSub.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }





}
