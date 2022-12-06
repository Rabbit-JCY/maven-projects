package com.jcy.service;

import com.jcy.config.SpringConfig;
import com.jcy.domain.Message;
import com.jcy.domain.User;
import com.jcy.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class MessageServiceBlackBoxTest {

    @Autowired
    private MessageService messageService;
    @Test
    public void testSend(){
        Message message1 = new Message(-1,1,2,"hello");
        boolean flag1 = messageService.send(message1);
        assert (!flag1);

        try {
            Message message2 = new Message(Integer.valueOf("A"),1,2,"hello");
            boolean flag2 = messageService.send(message2);
            assert (!flag2);
        } catch (NumberFormatException e) {
            System.out.println("flag2 is false.");
        }

        messageService.delete(1);
        Message message3 = new Message(1,1,2,"hello");
        boolean flag3 = messageService.send(message3);
        assert (flag3);

        Message message4 = new Message(1,2,1,"hello");
        boolean flag4 = messageService.send(message4);
        assert (!flag4);

        try {
            Message message5 = new Message(1,Integer.valueOf("A"),2,"hello");
            boolean flag5 = messageService.send(message5);
            assert (!flag5);
        } catch (NumberFormatException e) {
            System.out.println("flag5 is false.");
        }
    }

    @Test
    public void testDelete(){
        boolean flag1 = messageService.delete(-1);
        assert (!flag1);

        try{
            boolean flag2 = messageService.delete(Integer.valueOf("A"));
            assert (!flag2);
        } catch (NumberFormatException e) {
            System.out.println("flag2 is false.");
        }

        boolean flag3 = messageService.delete(1);
        assert (flag3);
    }

    @Test
    public void testUpdate(){
        try {
            Message message1 = new Message(Integer.valueOf("A"),1,2,"hello");
            boolean flag1 = messageService.update(message1);
            assert (!flag1);
        } catch (NumberFormatException e) {
            System.out.println("flag1 is false.");
        }

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
    public void testFindByFromId(){
        try {
            messageService.findByFromId(Integer.valueOf("A"));
        } catch (NumberFormatException e) {
            System.out.println("error parameter");
        }

        List<Message> list1 = messageService.findByFromId(1);
        assert (list1.size() > 0);

        List<Message> list2 = messageService.findByFromId(100);
        assert (list2.size() == 0);
    }

    @Test
    public void testFindByToId(){
        try {
            messageService.findByToId(Integer.valueOf("A"));
        } catch (NumberFormatException e) {
            System.out.println("error parameter");
        }

        List<Message> list1 = messageService.findByToId(1);
        assert (list1.size() > 0);

        List<Message> list2 = messageService.findByToId(100);
        assert (list2.size() == 0);
    }

    @Test
    public void testFindAll(){
        try {
//            List<User> list1 = messageService.findAll(1);
//            assert (list1 == null);
        } catch (Exception e) {
            System.out.println("list1 is null");
        }

        try {
//           List<User> list2 = messageService.findAll("A");
////            assert (list2 == null);
        } catch (Exception e) {
            System.out.println("list2 is null");
        }

        List<Message> list3 = messageService.findAll();
        assert (list3.size() > 0);
    }
}
