package com.jcy.dao;

import com.jcy.domain.Feedback;
import com.jcy.domain.File;
import org.apache.ibatis.annotations.Select;

public interface FeedbackDao {

    @Select("select * from Feedback where subNr=#{subNr}")
    public Feedback getFeedback(String subNr);
}
