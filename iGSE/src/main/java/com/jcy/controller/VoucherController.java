package com.jcy.controller;

import com.jcy.domain.Voucher;
import com.jcy.service.VoucherService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    @PostMapping("/checkCode")
    @ResponseBody
    public String checkCode(@RequestBody Map<String,String> mp){
        String code = mp.get("EVC_code");
        Voucher voucher = voucherService.getByCode(code);
        if(voucher == null){
            return "Fail. EVC_code does not exist!";
        }else if(voucher.getUsed() == 1){
            return "Fail. EVC_code has been used!";
        }else{
            return "success";
        }
    }

    @PostMapping("/useCode")
    @ResponseBody
    public String updateCode(@RequestBody Map<String,Object> mp){
        System.out.println("useCode");
        Voucher voucher = voucherService.getByCode(mp.get("EVC_code").toString());
        voucher.setUsed(1);
        voucherService.update(voucher);
        String response = voucher.getEVC_code();
        response += " has been used.";
        return response;
    }
}
