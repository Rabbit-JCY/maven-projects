package com.jcy.controller;

import com.jcy.domain.Customer;
import com.jcy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public String register(@RequestBody Customer customer){
        customerService.insert(customer);
        System.out.println("register...");
        return "login.jsp";
    }
}
