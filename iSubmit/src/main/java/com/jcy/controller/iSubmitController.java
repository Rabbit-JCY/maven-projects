package com.jcy.controller;

import com.jcy.domain.Feedback;
import com.jcy.domain.Submission;
import com.jcy.service.FeedbackService;
import com.jcy.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/iSubmit")
public class iSubmitController {
    @Autowired
    private SubmissionService submissionService;

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/submissions")
    @ResponseBody
    private String insert(@RequestBody Submission submission){
        submission.setDate(new Date());
        submission.setSubNr(submission.getStuId() + "_sub");
        submissionService.insert(submission);
        return submission.getSubNr();
    }


    @GetMapping("/feedbacks/{subNr}")
    @ResponseBody
    private Feedback getFeedback(@PathVariable String subNr){
        return feedbackService.getFeedback(subNr);
    }

}
