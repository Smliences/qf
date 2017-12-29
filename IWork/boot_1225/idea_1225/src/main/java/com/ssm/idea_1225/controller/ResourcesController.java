package com.ssm.idea_1225.controller;

import com.ssm.idea_1225.common.Constant;
import com.ssm.idea_1225.entity.Resources;
import com.ssm.idea_1225.entity.User;
import com.ssm.idea_1225.service.ResourcesService;
import org.apache.tomcat.util.bcel.classfile.ConstantDouble;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author sml
 * @Time 2017-12-27 17:47
 **/

@RestController
public class ResourcesController {
    @Resource
    private ResourcesService rs;

    @RequestMapping("findAllRes")
    public List<Resources> findAllRes() {
        System.out.println(rs.findAllRes());
        return rs.findAllRes();
    }

    @RequestMapping("findResByUser")
    public List<Resources> findResByUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return rs.findResByUser(user);
    }

    @RequestMapping("saveRes")
    public String saveRes(Resources res) {
        if (!res.getId().equals("0")) {
            rs.editRes(res);
        } else {
            rs.saveRes(res);
        }
        return Constant.RESULT_OK;
    }

    @RequestMapping("deleteRes")
    public String deleteRes(@RequestBody ArrayList<String> ids) {
        rs.deleteRes(ids);
        return Constant.RESULT_OK;
    }

    @RequestMapping("findResText")
    public List<Resources> findResText() {
       return rs.findResText();
    }
}
