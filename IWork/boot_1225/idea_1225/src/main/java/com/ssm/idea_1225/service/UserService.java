package com.ssm.idea_1225.service;

import com.ssm.idea_1225.dao.UserDao;
import com.ssm.idea_1225.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserDao ud;

    public List<User> findAllUser() {
        return ud.findAllUser();
    }

    public void deleteUserById(int id) {
        ud.deleteUserById(id);
    }

    public void deleteUser2(ArrayList<Integer> ids) {
        ud.deleteUser2(ids);
    }

    public void saveUser(User user) {
        ud.saveUser(user);
    }

    public void editUser(User user) {
        ud.editUser(user);
    }
}
