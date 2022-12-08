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
public class UserServiceWhiteBoxTest {

    @Autowired
    private UserService userService;

    @Test
    public void testRegister(){
        User user1 = new User(-1,"cj220","123");
        boolean flag1 = userService.register(user1);
        assert (flag1 == false);

        userService.delete(1);
        User user3 = new User(1,"cj220","123");
        boolean flag3 = userService.register(user3);
        assert (flag3 == true);

        User user4 = new User(1,"cj220","abc");
        boolean flag4 = userService.register(user4);
        assert (flag4 == false);

    }

    @Test
    public void testDelete(){
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
        userService.delete(100);
        User user1 = new User(100,"100","100");
        boolean flag1 = userService.update(user1);
        assert (flag1 == false);

        User user2 = new User(1,"111","111");
        User user3 = new User(1,"jia","123");
        userService.delete(1);
        userService.register(user2);
        boolean flag2 = userService.update(user3);
        assert (flag2 == true);
    }

    @Test
    public void testFindById(){
        User user1 = userService.findUserById(1);
        assert (user1 != null);

        User user3 = userService.findUserById(100);
        assert (user3 == null);
    }

    @Test
    public void testFindAll(){
        List<User> list3 = userService.findAllUser();
        assert (list3 != null);
    }

    @Test
    public void testLogin(){
        Integer id1 = 2;
        String password1 = "222";
        boolean flag1 = userService.login(id1,password1);
        assert (flag1);

        Integer id2 = 2;
        String password2 = "333";
        boolean flag2 = userService.login(id2,password2);
        assert (!flag2);

        Integer id3 = 100;
        String password3 = "111";
        boolean flag3 = userService.login(id3,password3);
        assert (!flag3);
    }
}
