package com.ssm.idea_1225.controller;

import com.ssm.idea_1225.common.Constant;
import com.ssm.idea_1225.entity.Role;
import com.ssm.idea_1225.service.RoleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author sml
 * @Time 2017-12-26 20:17
 **/
@RestController
public class RoleController {
    @Resource
    private RoleService rs;
    @RequestMapping("findAllRole")
    public List<Role> findAllRole() {
        return rs.findAllRole();
    }
    @RequestMapping("saveRole")
    public String saveRole(Role role) {
        if (!role.getId().equals("0")) {
            rs.editRole(role);
        } else {
            rs.saveRole(role);
        }
        return Constant.RESULT_OK;
    }
    @RequestMapping("deleteRole")
    public String deleteRole(@RequestBody ArrayList<Integer> ids) {
        rs.deleteRole(ids);
        return Constant.RESULT_OK;
    }
}
