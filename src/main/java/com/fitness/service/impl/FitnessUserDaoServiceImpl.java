package com.fitness.service.impl;

import com.fitness.dao.FitnessUserDao;
import com.fitness.entity.User;
import com.fitness.service.FitnessUserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-19 22:51
 */
@Service
public class FitnessUserDaoServiceImpl implements FitnessUserDaoService {

    @Autowired
    FitnessUserDao dao;


    @Override
    public List<User> verify(String username, String password) {
        return dao.getByUsernameStartingWithAndPassword(username, password);
    }

    @Override
    public User register(User user) {
        return dao.save(user);
    }

    @Override
    public String getUserName(String username) {
        List<User> result = dao.getByUsername(username);
        if (result.isEmpty()){
            return "-1";
        }else {
            return result.get(0).getUsername();
        }

    }
}
