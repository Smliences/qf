package com.ssm.idea_1225.dao;

import com.ssm.idea_1225.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Mapper
public interface UserDao {
    public List<User> findAllUser();

    void deleteUserById(int id);

    public void deleteUser2(ArrayList<Integer> ids);

    void saveUser(User user);

    void editUser(User user);
}
