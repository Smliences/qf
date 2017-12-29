package com.ssm.idea_1225.service;

import com.ssm.idea_1225.common.SecurityUtil;
import com.ssm.idea_1225.common.Utils;
import com.ssm.idea_1225.dao.RoleDao;
import com.ssm.idea_1225.dao.UserDao;
import com.ssm.idea_1225.entity.Role;
import com.ssm.idea_1225.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public void deleteUser2(ArrayList<String> ids) {
        ud.deleteUser2(ids);
    }
    @Transactional
    public void saveUser(User user) {
        user.setId(Utils.getUuid());
        user.setPwd(SecurityUtil.md5(user.getPwd()));
        ud.saveUser(user);
        ud.saveUserRole(user);
    }

    public void editUser(User user) {
        ud.editUser(user);
    }

    public List<Role> findRoleName() {
        return ud.findRoleName();
    }

    public User login(User user) {
        String pwd = SecurityUtil.md5(user.getPwd());
        user.setPwd(pwd);
        return ud.login(user);
    }
}
