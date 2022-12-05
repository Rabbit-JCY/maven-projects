package com.jcy.dao;

import com.jcy.domain.Message;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MessageDao {

    @Insert("insert into tbl_message values(#{id},#{from_id},#{to_id},#{information})")
    public void send(Message message);

    @Delete("delete from tbl_message where id=#{id}")
    public void delete(Integer id);

    @Update("update tbl_message set from_id=#{from_id},to_id=#{to_id},information=#{information} where id=#{id}")
    public void update(Message message);

    @Select("select * from tbl_message where id=#{id}")
    public Message findById(Integer id);

    @Select("select * from tbl_message")
    public List<Message> findAllUser();
    @Select("select * from tbl_message where from_id=#{from_id}")
    public List<Message>findByFromId(Integer from_id);

    @Select("select * from tbl_message where to_id=#{to_id}")
    public List<Message>findByToId(Integer to_id);
}

