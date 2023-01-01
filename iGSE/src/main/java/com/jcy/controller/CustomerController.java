package com.jcy.controller;

import com.jcy.domain.Customer;
import com.jcy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    @ResponseBody
    public Customer register(@RequestBody Customer customer) {
        System.out.println(customer.toString());
        System.out.println("register...");
//        customerService.insert(customer);

        return customer;
    }

    @RequestMapping("/login")
    @ResponseBody
    public String register(@RequestBody Map<String, Object> params) {
        System.out.println("email: " + params.get("email").toString());
        System.out.println("password:, " + params.get("password").toString());
        System.out.println("login...");
//        customerService.insert(customer);

        return "1";
    }

}
