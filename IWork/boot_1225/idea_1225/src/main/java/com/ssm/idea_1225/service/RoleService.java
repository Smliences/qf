package com.ssm.idea_1225.service;

import com.ssm.idea_1225.common.Utils;
import com.ssm.idea_1225.dao.RoleDao;
import com.ssm.idea_1225.entity.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author sml
 * @Time 2017-12-26 20:21
 **/
@Service
public class RoleService {
    @Resource
    private RoleDao rd;
    public List<Role> findAllRole(){
        return rd.findAllRole();
    }

    public void saveRole(Role role) {
        role.setId(Utils.getUuid());
        rd.saveRole(role);
    }

    public void editRole(Role role) {
        rd.editRole(role);
    }

    public void deleteRole(ArrayList<Integer> ids) {
        rd.deleteRole(ids);
    }
}
