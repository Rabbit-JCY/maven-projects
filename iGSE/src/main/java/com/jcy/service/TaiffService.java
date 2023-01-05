package com.jcy.service;

import com.jcy.domain.Taiff;

import java.util.List;

public interface TaiffService {

    public List<Taiff> getAll();

    public Taiff getByType(String name);

    public boolean update(Taiff taiff);
}
