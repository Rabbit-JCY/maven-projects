package com.jcy.service.impl;



import com.jcy.dao.MessageDao;
import com.jcy.domain.Message;
import com.jcy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    public boolean send(Message message) {
        messageDao.send(message);
        return true;
    }

    public boolean delete(Integer id) {
        messageDao.delete(id);
        return true;
    }

    public boolean update(Message message) {
        messageDao.update(message);
        return true;
    }

    public List<Message> findByFromId(Integer from_id) {
        return messageDao.findByFromId(from_id);
    }

    public List<Message> findByToId(Integer to_id) {
        return messageDao.findByToId(to_id);
    }

    public Message findById(Integer id) {
        return messageDao.findById(id);
    }

    public List<Message> findAll() {
        return messageDao.findAllUser();
    }
}
