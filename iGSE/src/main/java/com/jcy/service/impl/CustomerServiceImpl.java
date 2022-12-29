package com.jcy.service.impl;

import com.jcy.dao.CustomerDao;
import com.jcy.domain.Customer;
import com.jcy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public boolean insert(Customer customer){
        customerDao.insert(customer);
        return true;
    }
}
