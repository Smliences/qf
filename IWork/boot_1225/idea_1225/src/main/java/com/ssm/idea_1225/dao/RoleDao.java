package com.ssm.idea_1225.dao;

import com.ssm.idea_1225.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author sml
 * @Time 2017-12-26 20:22
 **/
@Repository
@Mapper
public interface RoleDao {
    public List<Role> findAllRole();

    void saveRole(Role role);

    void editRole(Role role);

    void deleteRole(ArrayList<Integer> ids);
}
