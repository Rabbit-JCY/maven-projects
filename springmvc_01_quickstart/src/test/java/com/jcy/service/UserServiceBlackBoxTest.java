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

        User user4 = new User(1,"chen","abc");
        boolean flag3 = userService.update(user4);
        assert (flag3 == true);
    }

    @Test
    public void testFindById(){
        User user1 = userService.findUserById(1);
        assert (user1 != null);

        try{
            User user2 = userService.findUserById(Integer.valueOf("a"));
            assert (user2 != null);
        } catch (NumberFormatException e) {
            System.out.println("user2 is null.");
        }

        User user3 = userService.findUserById(100);
        assert (user3 == null);
    }

    @Test
    public void testFindAll(){
        try {
//            List<User> list1 = userService.findAllUser(1);
//            assert (list1 == null);
        } catch (Exception e) {
            System.out.println("list1 is null");
        }

        try {
//            List<User> list2 = userService.findAllUser("a");
//            assert (list2 == null);
        } catch (Exception e) {
            System.out.println("list2 is null");
        }

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
