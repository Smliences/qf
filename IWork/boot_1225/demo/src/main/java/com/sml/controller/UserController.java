package com.sml.controller;

import com.sml.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @RequestMapping("user")
    public String findAllUser() {
//        ArrayList<User> x = new ArrayList<>();
//        x.add(new User("张三","aa"));
        return "123";
    }
}
