package com.example.brushany.repository;

import com.example.brushany.models.Product;
import com.example.brushany.util.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private Connection conn;
    public ProductRepository() {this.conn = DatabaseConnectionManager.getDatabaseConnection();}
/*
    int customerId;
    String name;
    String email;
    int phone;
    String address;
    String cpr;
  */

    public void create(Product product) {
        try {
            PreparedStatement createCustomer = conn.prepareStatement("INSERT INTO product(name, producer, price, date, active)" + "VALUES(?,?,?,?,?) ");
            createCustomer.setString(1, product.getName());
            createCustomer.setString(2, product.getProducer());
            createCustomer.setDouble(3, product.getPrice());
            createCustomer.setString(4, product.getDate());
            createCustomer.setBoolean(5, product.isActive());
            createCustomer.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Product> readAll() {
        ArrayList<Product> allProducts = new ArrayList<>();
        try{
            PreparedStatement readAllProducts = conn.prepareStatement("SELECT productId, name, producer, price, date, active FROM product");
            ResultSet rs = readAllProducts.executeQuery();
            while(rs.next()){
                Product tempProduct = new Product();
                tempProduct.setId(rs.getInt(1));
                tempProduct.setName(rs.getString(2));
                tempProduct.setProducer(rs.getString(3));
                tempProduct.setPrice(rs.getInt(4));
                tempProduct.setDate(rs.getString(5));
                tempProduct.setActive(rs.getBoolean(6));

                allProducts.add(tempProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allProducts;


    }

    public Product readSingleProduct(int productId) {
        Product tempProduct = new Product();
        try{
            PreparedStatement readtemp = conn.prepareStatement("SELECT * from product WHERE productId = ?");
            readtemp.setInt(1, productId);
            ResultSet rs = readtemp.executeQuery();
            while(rs.next()){
                tempProduct = new Product();
                tempProduct.setId(rs.getInt(1));
                tempProduct.setName(rs.getString(2));
                tempProduct.setProducer(rs.getString(3));
                tempProduct.setPrice(rs.getInt(4));
                tempProduct.setDate(rs.getString(5));
                tempProduct.setActive(rs.getBoolean(6));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return tempProduct;
    }



    public boolean update(Product product) {

        try{
            PreparedStatement updateproduct = conn.prepareStatement("UPDATE product SET name=?, producer=?, price=?, date=?, active=? WHERE productId =?");
            updateproduct.setString(1, product.getName());
            updateproduct.setString(2, product.getProducer());
            updateproduct.setDouble(3, product.getPrice());
            updateproduct.setString(4, product.getDate());
            updateproduct.setBoolean(5, product.isActive());
            updateproduct.setInt(6, product.getId());
            updateproduct.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }



    public boolean delete(int productId) {
        try {
            PreparedStatement deleteProduct = conn.prepareStatement("DELETE FROM product WHERE productId = ?");
            deleteProduct.setInt(1, productId);
            deleteProduct.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }



}
