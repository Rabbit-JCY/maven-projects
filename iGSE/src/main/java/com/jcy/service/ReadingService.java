package com.jcy.service;

import com.jcy.domain.Reading;

import java.util.List;

public interface ReadingService {

    public boolean insert(Reading reading);

    public boolean updateStatus(Reading reading);

    public Reading getByReaingId(Integer reading_id);

    public List<Reading> getByCustomerId(String customer_id);

    public List<Reading> getALl();
}
