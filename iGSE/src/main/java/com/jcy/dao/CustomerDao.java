package com.jcy.dao;

import com.jcy.domain.Customer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CustomerDao {

    @Insert("insert into Customer values(#{customer_id},#{password_hash},#{address},#{property_type}," +
            "#{bedroom_num},#{balance},#{type})")
    public void insert(Customer customer);

    @Delete("delete from Customer where customer_id=#{customer_id}")
    public void delete(Integer customer_id);

}

