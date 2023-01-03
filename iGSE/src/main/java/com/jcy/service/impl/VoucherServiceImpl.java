package com.jcy.service.impl;

import com.jcy.dao.VoucherDao;
import com.jcy.domain.Voucher;
import com.jcy.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoucherServiceImpl implements VoucherService {

    @Autowired
    private VoucherDao voucherDao;

    @Override
    public Voucher getByCode(String code) {
        return voucherDao.getByECVCode(code);
    }

    @Override
    public boolean update(Voucher voucher) {
        voucherDao.update(voucher);
        return true;
    }
}
