package com.jcy.dao;

import com.jcy.domain.Voucher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VoucherDao {

    @Select("select * from Voucher where EVC_code=#{ECV_code}")
    public Voucher getByECVCode(String EVC_code);

    @Select("select * from Voucher")
    public List<Voucher> getAll();
}
