package com.jcy.service.impl;

import com.jcy.dao.ReadingDao;
import com.jcy.domain.Reading;
import com.jcy.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    private ReadingDao readingDao;

    public boolean insert(Reading reading) {
        readingDao.insert(reading);
        return true;
    }
}
