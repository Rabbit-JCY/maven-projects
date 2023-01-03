package com.jcy.service;

import com.jcy.domain.Customer;
import com.jcy.domain.Reading;

public interface CustomerService {

    public boolean insert(Customer customer);

    public boolean updateBalance(Customer customer);

    public Customer getById(String customer_id);

}
