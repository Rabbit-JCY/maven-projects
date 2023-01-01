package com.jcy.controller;

import com.jcy.domain.Reading;
import com.jcy.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ReadingController {

    @Autowired
    private ReadingService readingService;

    @PostMapping("/submit")
    @ResponseBody
    public String register(@RequestBody Reading reading) {
        System.out.println(reading.toString());
        System.out.println("submit reading...");
        readingService.insert(reading);

        return "1";
    }


}
