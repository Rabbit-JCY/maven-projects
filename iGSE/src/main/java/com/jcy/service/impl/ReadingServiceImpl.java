package com.jcy.service.impl;

import com.jcy.dao.ReadingDao;
import com.jcy.domain.Reading;
import com.jcy.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    private ReadingDao readingDao;

    public boolean insert(Reading reading) {
        readingDao.insert(reading);
        return true;
    }

    public boolean updateStatus(Reading reading){
        String status = reading.getStatus();
        if(status.equals("paid")){
            return false;
        }else if(status.equals("pending")){
            reading.setStatus("paid");
            readingDao.updateStatus(reading);
            return true;
        }else{
            return false;
        }
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
