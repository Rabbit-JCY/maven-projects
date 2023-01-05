package com.jcy.service.impl;

import com.jcy.dao.CustomerDao;
import com.jcy.domain.Customer;
import com.jcy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public boolean insert(Customer customer){
        customerDao.insert(customer);
        return true;
    }

    public boolean updateBalance(Customer customer){
        customerDao.updateBalance(customer);
        return true;
    }

    @Override
    public Customer getById(String customer_id) {
        return customerDao.getById(customer_id);
    }

    @Override
    public List<Customer> getAll() {
        return customerDao.getALL("customer");
    }


}
