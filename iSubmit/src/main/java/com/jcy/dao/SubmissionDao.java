package com.jcy.dao;

import com.jcy.domain.Submission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.net.URL;
import java.util.List;

public interface SubmissionDao {
    @Insert("insert into Submission values(#{date},#{subNr},#{stuId},#{url})")
    public void insert(Submission submission);

    @Delete("delete from Submission where subNr=#{subNr}")
    public void delete(String subNr);

    @Update("update Submission set url=#{url} where subNr=#{subNr}")
    public void update(Submission submission);

    @Select("select * from Submission where subNr=#{subNr}")
    public Submission getSub(String subNr);

    @Select("select * from Submission")
    public List<Submission> getSubs();
}
