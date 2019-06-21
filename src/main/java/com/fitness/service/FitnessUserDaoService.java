package com.fitness.service;

import com.fitness.entity.User;

import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-19 22:49
 */
public interface FitnessUserDaoService  {


    /**
     * 校验用户
     * @param username
     * @param password
     * @return
     */
    List<User> verify(String username, String password);

    /**
     * 保存注册信息
     * @param user
     * @return
     */
    User register(User user);

    /**
     * 注册前，检查是否存在该用户
     * @param username
     * @return
     */
    String getUserName(String username);


}
