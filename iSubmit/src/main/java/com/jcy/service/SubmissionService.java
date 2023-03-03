package com.jcy.service;

import com.jcy.domain.Submission;

import java.net.URL;
import java.util.List;

public interface SubmissionService {
    public boolean insert(Submission submission);
    public Submission getSubmission(String subNr);
    public List<Submission> getSubmissions();
}
