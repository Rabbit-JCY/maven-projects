package com.jcy.service.BlackboxTesting;


import com.jcy.config.SpringConfig;
import com.jcy.domain.User;
import com.jcy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetById(){
        User user = userService.findUserById(1);
        System.out.println(user.toString());
    }

    @Test
    public void testGetAll(){
        List<User> books = userService.findAllUser();
        System.out.println(books);
    }

    @Test
    public void testDelete(){
        userService.delete(1);
        User book = userService.findUserById(1);
        System.out.println(book);
    }

    @Test
    public void testRegister(){
        User user = new User(4,"2","3");
        userService.register(user);
        System.out.println(user);
    }

    @Test
    public void testUpdate(){

    }


}
