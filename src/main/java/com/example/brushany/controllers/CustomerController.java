package com.example.brushany.controllers;

import com.example.brushany.models.Customer;
import com.example.brushany.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {


    @Autowired //binder controlleren sammen med service layer
            CustomerService customerService;


    @GetMapping("/")
    public String home(){

        return "customer/index";

    }

    @GetMapping("/createcustomer")
    public String createCustomer(Customer customer)
    {
        return "customer/createCustomer";
    }

    @PostMapping("/createdcustomer")
    public String oprettetmedlem(@ModelAttribute Customer customerFromPost){
        System.out.println(customerFromPost);
        customerService.create(customerFromPost);

        return "redirect:/customeroverview";

    }

    @GetMapping("/customeroverview")
    public String customerOverview(Model model){
        model.addAttribute("customers", customerService.readall());

        return "customer/customerOverview";

    }

    @GetMapping("/deletecustomer")
    public String deleteCustomer(@RequestParam int customerId){
        customerService.delete(customerId);

        return "redirect:/";

    }

    @GetMapping("/updatecustomer")
    public String updateCustomer(@RequestParam int customerId, Model model){
        Customer customer= customerService.read(customerId);
        model.addAttribute("customer", customer);
        return "customer/updatecustomer";

    }

    @PostMapping("/updatedcustomer")
    public String updatedsnus(@ModelAttribute Customer customerFromPost){
        customerService.update(customerFromPost);
        return "redirect:/customeroverview";

    }

    @GetMapping("/singlecustomer")
    public String singlesnus(@RequestParam int customerId, Model model){
        Customer tempCustomer = customerService.read(customerId);
        model.addAttribute("customer", tempCustomer);

        return "customer/singlecustomer";
    }



}
