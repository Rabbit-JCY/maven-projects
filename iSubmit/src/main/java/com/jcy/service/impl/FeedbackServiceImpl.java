package com.jcy.service.impl;

import com.jcy.dao.FeedbackDao;
import com.jcy.domain.Feedback;
import com.jcy.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackDao feedbackDao;

    @Override
    public Feedback getFeedback(String subNr) {
        return feedbackDao.getFeedback(subNr);
    }
}
