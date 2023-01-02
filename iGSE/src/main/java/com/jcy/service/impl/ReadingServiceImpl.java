package com.jcy.service.impl;

import com.jcy.dao.ReadingDao;
import com.jcy.domain.Reading;
import com.jcy.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    private ReadingDao readingDao;

    public boolean insert(Reading reading) {
        readingDao.insert(reading);
        return true;
    }

    public Reading getByReaingId(Integer reading_id) {
        return readingDao.getByReadingId(reading_id);
    }

    public List<Reading> getByCustomerId(String customer_id) {
        return readingDao.getByCustomerId(customer_id);
    }

    public List<Reading> getALl() {
        return readingDao.getAll();
    }


}
