package com.jcy.dao;

import com.jcy.domain.Reading;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;


public interface ReadingDao {

    @Insert("insert into Reading values(NULL,#{customer_id},#{submission_date},#{elec_readings_day}," +
            "#{elet_reading_night},#{gas_reading},#{status})")
    public void insert(Reading reading);

    @Delete("delete from Reading where reading_id=#{reading_id}")
    public void delete(Integer reading_id);
}
