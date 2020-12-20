package com.example.brushany.service;

import com.example.brushany.models.Customer;
import com.example.brushany.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public void create(Customer customer){
        customerRepository.create(customer);

    }

    public Boolean update(Customer customerFromPost){
        customerRepository.update(customerFromPost);

        return false;

    }

    public List readall(){

        ArrayList<Customer> customerArrayList = new ArrayList<>();
        for(Customer customer : customerRepository.readAll()){
            customerArrayList.add(customer);
        }
        return customerArrayList;
    }



    public void delete(int customerId){
        customerRepository.delete(customerId);}

    public Customer read(int customerId){


        Customer customerToReturn = customerRepository.readSingleCustomer(customerId);

        return customerToReturn;

    }






}
