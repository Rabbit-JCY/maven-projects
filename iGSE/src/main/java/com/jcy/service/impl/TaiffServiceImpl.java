package com.jcy.service.impl;

import com.jcy.dao.TaiffDao;
import com.jcy.domain.Taiff;
import com.jcy.service.TaiffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaiffServiceImpl implements TaiffService {

    @Autowired
    private TaiffDao taiffDao;

    @Override
    public List<Taiff> getAll() {
        return taiffDao.getAll();
    }

    @Override
    public Taiff getByType(String name) {
        return taiffDao.getByTaiffType(name);
    }

    @Override
    public boolean update(Taiff taiff) {
        return taiffDao.update(taiff);
    }
}
