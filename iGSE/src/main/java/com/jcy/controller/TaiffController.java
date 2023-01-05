package com.jcy.controller;

import com.jcy.domain.Taiff;
import com.jcy.service.TaiffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class TaiffController {

    @Autowired
    private TaiffService taiffService;

    @PostMapping("/getPrice")
    @ResponseBody
    public List<Taiff> getAll(){
        return taiffService.getAll();
    }

    @PostMapping("/setPrice")
    @ResponseBody
    public String update(@RequestBody Map<String,Float> mp){
        float day = mp.get("electricity_day");
        float night = mp.get("electricity_night");
        float gas = mp.get("gas");
        float charge = mp.get("sanding_charge");
        Taiff taiff1 = taiffService.getByType("electricity_day");
        Taiff taiff2 = taiffService.getByType("electricity_night");
        Taiff taiff3 = taiffService.getByType("gas");
        Taiff taiff4 = taiffService.getByType("sanding_charge");
        taiff1.setRate(day);
        taiff2.setRate(night);
        taiff3.setRate(gas);
        taiff4.setRate(charge);
        taiffService.update(taiff1);
        taiffService.update(taiff2);
        taiffService.update(taiff3);
        taiffService.update(taiff4);

        return "Update successfully!";
    }
}
