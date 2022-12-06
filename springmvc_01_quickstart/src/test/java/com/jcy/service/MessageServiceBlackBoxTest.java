package com.jcy.service;

import com.jcy.config.SpringConfig;
import com.jcy.domain.Message;
import com.jcy.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class MessageServiceBlackBoxTest {

    @Autowired
    private MessageService messageService;
    @Test
    public void testDelete(){
        Message message = new Message(111,1,1,"111");
        messageService.delete(111);
        messageService.send(message);
        messageService.delete(111);
    }
}
