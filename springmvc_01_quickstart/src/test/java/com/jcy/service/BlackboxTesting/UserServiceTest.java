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




}
