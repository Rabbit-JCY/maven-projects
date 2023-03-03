package com.jcy.service.impl;

import com.jcy.dao.SubmissionDao;
import com.jcy.domain.Submission;
import com.jcy.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    @Autowired
    private SubmissionDao submissionDao;

    @Override
    public boolean insert(Submission submission) {
        submissionDao.insert(submission);
        return true;
    }

    @Override
    public Submission getSubmission(String subNr) {
        return submissionDao.getSub(subNr);
    }

    @Override
    public List<Submission> getSubmissions() {
        return submissionDao.getSubs();
    }
}
