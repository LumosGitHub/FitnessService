package com.fitness.service.impl;

import com.fitness.service.TrainService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-21 10:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainServiceImplTest {


    @Autowired
    TrainService service;

    @Test
    public void addNewTrainRecord() {

        System.out.println(service.addNewTrainRecord(1, 8));

    }
}