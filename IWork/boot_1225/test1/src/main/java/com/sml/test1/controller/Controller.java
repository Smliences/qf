package com.sml.test1.controller;

import com.sml.test1.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @RequestMapping("user")
    public List<User> run() {
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(new User("张三","123"));
        return userList;
    }
}
