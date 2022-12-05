package com.jcy.service;

import com.jcy.domain.Message;

import java.util.List;

public interface MessageService {

    public boolean send(Message message);

    public boolean delete(Integer id);

    public boolean update(Message message);

    public List<Message> findByFromId(Integer id);

    public List<Message> findByToId(Integer id);

    public Message findById(Integer id);

    public List<Message> findAll();

}
