package com.ssm.idea_1225.controller;

import com.ssm.idea_1225.Constant;
import com.ssm.idea_1225.entity.User;
import com.ssm.idea_1225.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Resource
    private UserService us;

    @RequestMapping("findAllUser")
    public List<User> getAllUser() {
//        ArrayList<User> userList = new ArrayList<>();
//        userListList.add(new User(0,"zhagnsan","123"));
        return us.findAllUser();
    }

    @RequestMapping("deleteUser")
    public String deleteUser(int uid) {
        us.deleteUserById(uid);
        return "";
    }

    @RequestMapping("deleteUser2")
    public String deleteUser2(@RequestBody ArrayList<Integer> ids) {
        us.deleteUser2(ids);
        return Constant.RESULT_OK;
    }

    @RequestMapping("saveUser")
    public String saveUser(User user) {
        if (user.getId() != 0) {
            us.editUser(user);
        } else {
            us.saveUser(user);
        }
        return Constant.RESULT_OK;
    }
}
