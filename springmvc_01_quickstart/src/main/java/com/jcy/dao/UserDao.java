package com.jcy.dao;

import com.jcy.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {

    @Insert("insert into tbl_user values(#{id},#{name},#{password})")
    public void register(User user);

    @Delete("delete from tbl_user where id=#{id}")
    public void delete(Integer id);

    @Update("update tbl_user set name=#{name}, password=#{password} where id=#{id}")
    public void update(User user);

    @Select("select * from tbl_user where id=#{id}")
    public User findUserById(Integer id);

    @Select("select * from tbl_user")
    public List<User> findAllUser();
}
