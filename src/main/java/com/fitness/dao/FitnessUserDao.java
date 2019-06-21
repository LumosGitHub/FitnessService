package com.fitness.dao;

import com.fitness.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-19 22:47
 */
public interface FitnessUserDao extends JpaRepository<User, Integer> {

    /**
     * 账号密码校验
     * @param username
     * @param password
     * @return
     */
    List<User> getByUsernameStartingWithAndPassword(String username, String password);

    /**
     * 根据username获取信息，用于注册前的检查
     * @param username
     * @return
     */
    List<User> getByUsername(String username);

}
