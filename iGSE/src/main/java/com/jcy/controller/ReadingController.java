package com.jcy.controller;

import com.jcy.domain.Reading;
import com.jcy.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping("/getByReadingId")
    @ResponseBody
    public Reading getByReadingId(@RequestBody Map<String,Integer> params){
        Integer id = params.get("reading_id");
        return readingService.getByReaingId(id);
    }

    @PostMapping("/getByCustomerId")
    @ResponseBody
    public List<Reading> getByCustomerId(@RequestBody Map<String,String> params){
        String id = params.get("customer_id");
//        System.out.println("customer_id:" + id.toString());
        return readingService.getByCustomerId(id);
    }

    @PostMapping("/getAll")
    @ResponseBody
    public List<Reading> getAll(){
        return readingService.getALl();
    }

}
