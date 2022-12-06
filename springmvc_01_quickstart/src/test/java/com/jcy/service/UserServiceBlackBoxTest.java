package com.jcy.service;


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
public class UserServiceBlackBoxTest {

    @Autowired
    private UserService userService;

    @Test
    public void testRegister(){
        User user1 = new User(-1,"cj220","123");
        boolean flag1 = userService.register(user1);
        assert (flag1 == false);

        User user2 = new User(0,"cj220","123");
        boolean flag2 = userService.register(user2);
        assert (flag2 == false);

        userService.delete(1);
        User user3 = new User(1,"cj220","123");
        boolean flag3 = userService.register(user3);
        assert (flag3 == true);

        User user4 = new User(1,"cj220","abc");
        boolean flag4 = userService.register(user4);
        assert (flag4 == false);

        userService.delete(10);
        User user5 = new User(10,"chen","123");
        boolean flag5 = userService.register(user5);
        assert (flag5 == true);

        User user6 = new User(10,"chen","1@3");
        boolean flag6 = userService.register(user6);
        assert (flag6 == false);
    }
    @Test
    public void testDelete(){
        try {
            boolean flag1 = userService.delete(Integer.valueOf("a"));
            assert (flag1 == false);
        } catch (NumberFormatException e) {
            System.out.println("flag1 is false.");
        }

        if(userService.findUserById(1) == null){
            User user = new User(1,"111","111");
            userService.register(user);
        }
        boolean flag2 = userService.delete(1);
        assert (flag2 == true);

        boolean flag3 = userService.delete(100);
        assert (flag3 == false);
    }
    @Test
    public void testUpdate(){

    }


}
