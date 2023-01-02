package com.jcy.dao;

import com.jcy.domain.Taiff;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TaiffDao {

    @Select("select * from Taiff where taiff_type=#{taiff_type}")
    public Taiff getByTaiffType(String taiff_type);

    @Select("select * from Taiff")
    public List<Taiff> getAll();

}
