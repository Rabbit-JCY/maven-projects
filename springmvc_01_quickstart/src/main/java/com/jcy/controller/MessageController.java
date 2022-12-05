package com.jcy.controller;

import com.jcy.domain.Message;
import com.jcy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping
    public String send(@RequestBody Message message){
        messageService.send(message);
        return "send successfully!";
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return messageService.delete(id);
    }

    @PutMapping
    public boolean update(@RequestBody Message message){
        return messageService.update(message);
    }

    @GetMapping("/{id}")
    @ResponseBody // 返回json对象而不是页面
    public Message getById(@PathVariable Integer id) {
        return messageService.findById(id);
    }

    @GetMapping
    @ResponseBody
    public List<Message> findALlUser(){
        return messageService.findAll();
    }

    @GetMapping("findByFromId/{from_id}")
    @ResponseBody
    public List<Message> findByFromId(@PathVariable Integer from_id){
        return messageService.findByFromId(from_id);
    }

    @GetMapping("findByToId/{to_id}")
    @ResponseBody
    public List<Message> findByToId(@PathVariable Integer to_id){
        return messageService.findByToId(to_id);
    }



}
