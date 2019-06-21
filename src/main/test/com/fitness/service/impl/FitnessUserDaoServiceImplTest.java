package com.fitness.service.impl;

import com.fitness.dao.FitnessUserDao;
import com.fitness.service.FitnessUserDaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-20 15:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FitnessUserDaoServiceImplTest {

    @Autowired
    FitnessUserDaoService service;

    @Test
    public void verify() {
    }

    @Test
    public void register() {
    }

    @Test
    public void getUserName() {

        System.out.println(service.getUserName("2"));

    }
}