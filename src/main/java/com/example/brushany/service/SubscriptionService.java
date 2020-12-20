package com.example.brushany.service;

import com.example.brushany.models.Subscription;
import com.example.brushany.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;


    public void create(Subscription subscription){
        subscriptionRepository.create(subscription);
    }



    public Boolean update(Subscription subscriptionFromPost){
        subscriptionRepository.update(subscriptionFromPost);

        return false;

    }

    public List readall(){

        ArrayList<Subscription> subArrayList = new ArrayList<>();
        for(Subscription s : subscriptionRepository.readAll()){
            subArrayList.add(s);
        }
        return subArrayList;
    }



    public void delete(int subscriptionId){

        subscriptionRepository.delete(subscriptionId);}




    public Subscription read(int subscriptionId){


        Subscription subToReturn = subscriptionRepository.readSingleSubscription(subscriptionId);

        return subToReturn;

    }




}
