package com.jcy.controller;

import com.jcy.domain.Customer;
import com.jcy.domain.Reading;
import com.jcy.domain.Statistics;
import com.jcy.service.CustomerService;
import com.jcy.service.ReadingService;
import com.jcy.service.TaiffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RestAPIController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ReadingService readingService;

    @Autowired
    private TaiffService taiffService;

    @GetMapping(value = "/igse/getpropertycount",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getPropertyCount(){
        Map<String,Integer> mp = new HashMap<String,Integer>();
        String[] arr = {"detached","semi-detached","terraced","flat","cottage","bungalow","mansion"};
        mp.put("detached", 0);
        mp.put("semi-detached", 0);
        mp.put("terraced", 0);
        mp.put("flat", 0);
        mp.put("cottage", 0);
        mp.put("bungalow", 0);
        mp.put("mansion", 0);
        List<Customer> list = customerService.getAll();
        for(int i = 0; i < list.size(); i++){
            Customer c = list.get(i);
            mp.put(c.getProperty_type(), mp.get(c.getProperty_type()) + 1);
        }
        String res = "[\n\t";
        for(int i = 0; i < mp.size(); i++){
            res += "{\n\t";
            res += "\"" + arr[i] + "\" : \"" + mp.get(arr[i]).toString() + "\"\n";
            res += "\t}\n";
            if(i < mp.size()-1){
                res += ",";
            }
        }
        res += "\n]";

        return res;
    }

    @GetMapping("/igse/{type}/{num}")
    @ResponseBody
    public String getStatistics(@PathVariable String type, @PathVariable Integer num){
        String str = "";
        List<Customer> list_all = customerService.getAll();
        List<Customer> list_c = new ArrayList<>();
        for(int i = 0; i < list_all.size(); i++){
            Customer customer = list_all.get(i);
            if(customer.getBedroom_num() == num){
                list_c.add(customer);
            }
        }

        double bill = 0;
        int number = list_c.size();
        float day_price = taiffService.getByType("electricity_day").getRate();
        float night_price = taiffService.getByType("electricity_night").getRate();
        float gas_price = taiffService.getByType("gas").getRate();
        float ele_day = 0;
        float ele_night = 0;
        float Gas = 0;
        for(int i = 0; i < list_c.size(); i++){
            String customer_id = list_c.get(i).getCustomer_id();
            List<Reading> list_r = readingService.getByCustomerId(customer_id);
            if(list_r.size() < 2){
                number -= 1;
            }else {
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                Reading reading = list_r.get(list_r.size() - 1);
                Reading reading1 = list_r.get(list_r.size() - 2);

                Float day = reading.getElec_readings_day();
                Float night = reading.getElet_reading_night();
                Float gas = reading.getGas_reading();
                String date = fmt.format(reading.getSubmission_date());

                Float day1 = reading1.getElec_readings_day();
                Float night1 = reading1.getElet_reading_night();
                Float gas1 = reading1.getGas_reading();
                String date1 = fmt.format(reading1.getSubmission_date());

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDateTime date3 = LocalDate.parse(date, dtf).atStartOfDay();
                LocalDateTime date4 = LocalDate.parse(date1, dtf).atStartOfDay();
                long daysBetween = Duration.between(date4, date3).toDays() + 1;

                Gas += (gas - gas1) / daysBetween;
                ele_day += (day - day1) / daysBetween;
                ele_night += (night - night1) / daysBetween;
            }
        }
        if(number == 0){
            bill = 0;
        }else{
            bill = (day_price*ele_day + night_price*ele_night + Gas*gas_price) / number;
        }

        str += "{\n\t";
        str += "\"type\":\"" + type + "\",\n\t";
        str += "\"bedroom\":\"" + num.toString() + "\",\n\t";
        str += "\"average_electricity_gas_cost_per_day\":\"" + String.valueOf(bill) + "\",\n\t";
        str += "\"unit\":\"pound\"\n";
        str += "}";
        return str;
    }
}
