package com.jcy.dao;

import com.jcy.domain.Customer;
import com.jcy.domain.Reading;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;


public interface ReadingDao {

    @Insert("insert into Reading values(NULL,#{customer_id},#{submission_date},#{elec_readings_day}," +
            "#{elet_reading_night},#{gas_reading},#{status})")
    public void insert(Reading reading);

    @Delete("delete from Reading where reading_id=#{reading_id}")
    public void delete(Integer reading_id);

    @Update("update Reading set status=#{status} where reading_id=#{reading_id}")
    public void updateStatus(Reading reading);

    @Select("select * from Reading")
    public List<Reading> getAll();

    @Select("select * from Reading where reading_id=#{reading_id}")
    public Reading getByReadingId(Integer reading_id);

    @Select("select * from Reading where customer_id=#{customer_id}")
    public List<Reading> getByCustomerId(String customer_id);
}
