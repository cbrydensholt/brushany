package com.example.brushany.repository;


import com.example.brushany.models.Customer;
import com.example.brushany.util.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {


    private Connection conn;
    public CustomerRepository() {this.conn = DatabaseConnectionManager.getDatabaseConnection();}
/*
    int customerId;
    String name;
    String email;
    int phone;
    String address;
    String cpr;
  */

    public void create(Customer customer) {
        try {
            PreparedStatement createCustomer = conn.prepareStatement("INSERT INTO customer(name, email, phone, address, cpr)" + "VALUES(?,?,?,?,?)");
            createCustomer.setString(1, customer.getName());
            createCustomer.setString(2, customer.getEmail());
            createCustomer.setInt(3, customer.getPhone());
            createCustomer.setString(4, customer.getAddress());
            createCustomer.setString(5, customer.getCpr());
            createCustomer.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Customer> readAll() {
        ArrayList<Customer> allCustomers = new ArrayList<>();
        try{
            PreparedStatement readAllSnus = conn.prepareStatement("SELECT * from customer");
            ResultSet rs = readAllSnus.executeQuery();
            while(rs.next()){
                Customer tempCustomer = new Customer();
                tempCustomer.setCustomerId(rs.getInt(1));
                tempCustomer.setName(rs.getString(2));
                tempCustomer.setEmail(rs.getString(3));
                tempCustomer.setPhone(rs.getInt(4));
                tempCustomer.setAddress(rs.getString(5));
                tempCustomer.setCpr(rs.getString(6));

                allCustomers.add(tempCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCustomers;


    }

    public Customer readSingleCustomer(int customerId) {
        Customer tempCustomer = new Customer();
        try{
            PreparedStatement readtemp = conn.prepareStatement("SELECT * from customer WHERE customerId = ?");
            readtemp.setInt(1, customerId);
            ResultSet rs = readtemp.executeQuery();
            while(rs.next()){
                tempCustomer = new Customer();
                tempCustomer.setCustomerId(rs.getInt(1));
                tempCustomer.setName(rs.getString(2));
                tempCustomer.setEmail(rs.getString(3));
                tempCustomer.setPhone(rs.getInt(4));
                tempCustomer.setAddress(rs.getString(5));
                tempCustomer.setCpr(rs.getString(6));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return tempCustomer;
    }



    public boolean update(Customer customer) {

        try{
            PreparedStatement updatesnus = conn.prepareStatement("UPDATE customer SET name=?, email=?, phone=?, address=?, cpr=? WHERE customerId =?");
            updatesnus.setString(1, customer.getName());
            updatesnus.setString(2, customer.getEmail());
            updatesnus.setInt(3, customer.getPhone());
            updatesnus.setString(4, customer.getAddress());
            updatesnus.setString(5, customer.getCpr());
            updatesnus.setInt(6, customer.getCustomerId());
            updatesnus.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }



    public boolean delete(int customerId) {
        try {
            PreparedStatement deleteCustomer = conn.prepareStatement("DELETE FROM customer WHERE customerId = ?");
            deleteCustomer.setInt(1, customerId);
            deleteCustomer.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }




}
