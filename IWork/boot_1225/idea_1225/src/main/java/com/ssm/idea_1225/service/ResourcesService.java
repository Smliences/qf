package com.ssm.idea_1225.service;

import com.ssm.idea_1225.common.SecurityUtil;
import com.ssm.idea_1225.dao.ResourcesDao;
import com.ssm.idea_1225.entity.Resources;
import com.ssm.idea_1225.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author sml
 * @Time 2017-12-27 17:48
 **/

@Service
public class ResourcesService {
    @Resource
    private ResourcesDao rd;

    public List<Resources> findAllRes() {
        return rd.findAllRes();
    }

    public List<Resources> findResByUser(User user) {
        return rd.findResByUser(user);
    }

    public void saveRes(Resources res) {
        res.setId(SecurityUtil.md5(res.getId()));
        rd.saveRes(res);
    }

    public void editRes(Resources res) {
        rd.editRes(res);
    }

    public void deleteRes(ArrayList<String> ids) {
    }

    public List<Resources> findResText() {
        return rd.findResText();
    }
}
