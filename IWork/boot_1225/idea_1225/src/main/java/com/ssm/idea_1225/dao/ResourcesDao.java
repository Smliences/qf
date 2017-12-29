package com.ssm.idea_1225.dao;

import com.ssm.idea_1225.entity.Resources;
import com.ssm.idea_1225.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ResourcesDao {
    List<Resources> findAllRes();

    List<Resources> findResByUser(User user);

    void saveRes(Resources res);

    void editRes(Resources res);

    List<Resources> findResText();
}
