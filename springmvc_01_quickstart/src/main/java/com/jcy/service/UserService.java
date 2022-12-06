package com.jcy.service;

import com.jcy.domain.User;

import java.util.List;

public interface UserService {

    public boolean register(User user);

    public boolean login(Integer id, String password);

    public boolean delete(Integer id);

    public boolean update(User user);

    public User findUserById(Integer id);

    public List<User> findAllUser();
}
