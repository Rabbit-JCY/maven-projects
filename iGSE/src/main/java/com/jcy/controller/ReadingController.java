package com.jcy.controller;

import com.jcy.domain.Customer;
import com.jcy.domain.Reading;
import com.jcy.service.CustomerService;
import com.jcy.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ReadingController {

    @Autowired
    private ReadingService readingService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/submit")
    @ResponseBody
    public String submit(@RequestBody Reading reading) {
        String customer_id = reading.getCustomer_id();
        List<Reading> list = readingService.getByCustomerId(customer_id);
        if(list.size() > 0){
            Reading last_reading = list.get(list.size()-1);

            Float day = reading.getElec_readings_day();
            Float last_day = last_reading.getElec_readings_day();
            Float night = reading.getElet_reading_night();
            Float last_night = last_reading.getElet_reading_night();
            Float gas = reading.getGas_reading();
            Float last_gas = last_reading.getGas_reading();

            DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
            String date = fmt.format(reading.getSubmission_date());
            String last_date = fmt.format(last_reading.getSubmission_date());
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime date1 = LocalDate.parse(date, dtf).atStartOfDay();
            LocalDateTime last_date1 = LocalDate.parse(last_date, dtf).atStartOfDay();
            long daysBetween = Duration.between(last_date1, date1).toDays();

            if(daysBetween < 0){
                return "Fail. The submission date is wrong. The last submission date is after today.";
            }else if(day - last_day < 0){
                return "Fail. The ele_day should not be less than the last submitted data.";
            }else if(night - last_night < 0){
                return "Fail. The ele_night should not be less than the last submitted data.";
            }else if(gas - last_gas < 0){
                return "Fail. The ele_night should not be less than the last submitted data.";
            }else if((day + night + gas - last_gas - last_day - last_night) == 0 && daysBetween == 0){
                return "Fail. The reading is the same as the last one.";
            }else{
                readingService.insert(reading);
                return "Submit successfully!";
            }
        }else{
            readingService.insert(reading);
            return "Submit successfully!";
        }
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
