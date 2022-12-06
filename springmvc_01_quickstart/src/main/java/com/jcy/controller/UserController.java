package com.jcy.controller;

import com.jcy.domain.User;
import com.jcy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String register(@RequestBody User user){
        userService.register(user);
        return "success";
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

    @PutMapping
    public boolean update(@RequestBody User user){
        return userService.update(user);
    }

    @GetMapping("/{id}")
    @ResponseBody // 返回json对象而不是页面
    public User findUserById(@PathVariable Integer id) {
        return userService.findUserById(id);
    }

    @GetMapping
    @ResponseBody
    public List<User> findALlUser(){
        return userService.findAllUser();
    }



}
