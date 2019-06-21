package com.fitness.controller;

import com.alibaba.fastjson.JSONArray;
import com.fitness.entity.User;
import com.fitness.service.FitnessUserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-19 22:38
 */
@Controller
public class UserController {


    String ERROR = "{'info':'error'}";
    @Autowired
    FitnessUserDaoService service;


    @PostMapping("login")
    @ResponseBody
    public String login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<User> users = service.verify(username, password);
        if (users.isEmpty() || users.size() > 1) {
            User user = new User();
            user.setUserId(0);
            return JSONArray.toJSONString(user);
        } else {
            return JSONArray.toJSONString(users.get(0));
        }

    }

    @PostMapping("register")
    @ResponseBody
    public String register(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setHeight(Double.parseDouble(height));
        user.setWeight(Double.parseDouble(weight));
        user.setSex(sex);
        String checkUserName = service.getUserName(username);
        if (checkUserName.equals(username)) {
            return JSONArray.toJSONString("该用户已经存在!");
        } else {
            User result = service.register(user);
            boolean checkUser = result.getUsername().equals(user.getUsername());
            if (checkUser) {
                return JSONArray.toJSONString(result);
            } else {
                return JSONArray.toJSONString("注册失败，请稍后重试!");
            }
        }
    }


}
