package com.jcy.service;

import com.jcy.domain.Voucher;

public interface VoucherService {

    public Voucher getByCode(String code);

    public boolean update(Voucher voucher);
}
