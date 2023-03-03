package com.jcy.dao;

import com.jcy.domain.File;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.net.URL;
import java.util.List;

public interface FileDao {

    @Insert("insert into File values(#{name},#{content},#{url})")
    public void insert(File file);

    @Delete("delete from File where name=#{name}")
    public void delete(String name);

    @Update("update File set content=#{content} where name=#{name}")
    public void update(File file);

    @Select("select * from File where name=#{name}")
    public File getFile(String name);

    @Select("select * from File where url=#{url}")
    public File getByURL(String url);

    @Select("select * from File")
    public List<File> getFiles();
}
