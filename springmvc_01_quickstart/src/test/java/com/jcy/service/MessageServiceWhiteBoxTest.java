package com.jcy.service;

import com.jcy.config.SpringConfig;
import com.jcy.domain.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class MessageServiceWhiteBoxTest {

    @Autowired
    private MessageService messageService;
    @Test
    public void testSend(){
        Message message1 = new Message(-1,1,2,"hello");
        boolean flag1 = messageService.send(message1);
        assert (!flag1);

        messageService.delete(1);
        Message message3 = new Message(1,1,2,"hello");
        boolean flag3 = messageService.send(message3);
        assert (flag3);
    }

    @Test
    public void testDelete(){
        boolean flag1 = messageService.delete(-1);
        assert (!flag1);

        boolean flag3 = messageService.delete(1);
        assert (flag3);
    }

    @Test
    public void testUpdate(){
        messageService.delete(1);
        Message message2 = new Message(1,1,2,"hello");
        Message message3 = new Message(1,1,2,"world");
        messageService.send(message2);
        boolean flag2 = messageService.update(message3);
        assert (flag2);

        Message message4 = new Message(1,1,3,"world");
        boolean flag3 = messageService.update(message4);
        assert (flag3);
    }

    @Test
    public void testFindById(){

        Message message = messageService.findById(1);
        assert (message != null);

        Message message1 = messageService.findById(100);
        assert (message1 == null);
    }

    @Test
    public void testFindByFromId(){

        List<Message> list1 = messageService.findByFromId(1);
        assert (list1.size() > 0);

        List<Message> list2 = messageService.findByFromId(100);
        assert (list2.size() == 0);
    }



    @Test
    public void testFindByToId(){
        List<Message> list1 = messageService.findByToId(1);
        assert (list1.size() > 0);

        List<Message> list2 = messageService.findByToId(100);
        assert (list2.size() == 0);
    }

    @Test
    public void testFindAll(){
        List<Message> list3 = messageService.findAll();
        assert (list3.size() > 0);
    }
}
