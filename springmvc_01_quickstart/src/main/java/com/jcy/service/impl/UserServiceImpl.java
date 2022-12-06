package com.jcy.service.impl;

import com.jcy.dao.UserDao;
import com.jcy.domain.User;
import com.jcy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public boolean register(User user) {
        if(user.getId() <= 0 ){
            return false;
        }else if(userDao.findUserById(user.getId()) != null){
            return false;
        }else{
            userDao.register(user);
            return true;
        }
    }

    public boolean login(Integer id, String password){
        if(userDao.findUserById(id) == null){
            return false;
        }else{
            User user = userDao.findUserById(id);
            if(user.getPassword().equals(password)){
                return true;
            }else{
                return false;
            }
        }
    }

    public boolean delete(Integer id) {
        if(userDao.findUserById(id) == null){
            return false;
        }else{
            userDao.delete(id);
            return true;
        }
    }

   public boolean update(User user){
        if(userDao.findUserById(user.getId()) == null){
            return false;
        }else{
            userDao.update(user);
            return true;
        }

   }

    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    public List<User> findAllUser() {
        return userDao.findAllUser();
    }
}
