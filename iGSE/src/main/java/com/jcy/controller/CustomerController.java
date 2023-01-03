package com.jcy.controller;

import com.jcy.dao.TaiffDao;
import com.jcy.domain.Customer;
import com.jcy.domain.Reading;
import com.jcy.domain.Taiff;
import com.jcy.service.CustomerService;
import com.jcy.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ReadingService readingService;
    @Autowired
    private TaiffDao taiffDao;

    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestBody Customer customer) {
        String customer_id = customer.getCustomer_id();
        Customer customer1 = customerService.getById(customer_id);
        if(customer1 != null){
            return "Email has already been used.";
        }else{
//            customerService.insert(customer);
            return "success";
        }
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody Map<String, Object> params) {
        System.out.println("email: " + params.get("email").toString());
        System.out.println("password:, " + params.get("password").toString());
        System.out.println("login...");
//        customerService.insert(customer);

        return "1";
    }

    @RequestMapping("/pay")
    @ResponseBody
    public String payByReadingId(@RequestBody Map<String,Object> params){
        Integer id = Integer.parseInt(params.get("reading_id").toString());
        List<Reading> list = readingService.getByCustomerId(params.get("customer_id").toString());
        List<Taiff> list1 = taiffDao.getAll();
        Float type1 = list1.get(0).getRate();
        Float type2 = list1.get(1).getRate();
        Float type3 = list1.get(2).getRate();
        Float type4 = list1.get(3).getRate();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getReading_id() == id){
                if(i == 0){
                    return "Fail";
                } else if (list.get(i).getStatus() == "paid") {
                    return "Fail. This bill has already been paid.";
                } else{
                    DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
                    Reading reading = list.get(i);
                    Float day = reading.getElec_readings_day();
                    Float night = reading.getElet_reading_night();
                    Float gas = reading.getGas_reading();
                    String date = fmt.format(reading.getSubmission_date());

                    Reading reading1 = list.get(i-1);
                    Float day1 = reading1.getElec_readings_day();
                    Float night1 = reading1.getElet_reading_night();
                    Float gas1 = reading1.getGas_reading();
                    String date1 = fmt.format(reading1.getSubmission_date());

                    System.out.println(date);
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDateTime date3 = LocalDate.parse(date, dtf).atStartOfDay();
                    LocalDateTime date4 = LocalDate.parse(date1, dtf).atStartOfDay();
                    long daysBetween = Duration.between(date4, date3).toDays();
                    Float bill = (day-day1)*type1+(night-night1)*type2+(gas-gas1)*type3+daysBetween*type4;

                    readingService.updateStatus(reading);

                    return "Success. You have paid " + bill.toString() + " £.";
                }
            }
        }

        return "fail";
    }

}
