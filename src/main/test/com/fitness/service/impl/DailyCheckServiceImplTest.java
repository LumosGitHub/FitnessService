package com.fitness.service.impl;

import com.fitness.service.DailyCheckService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;

import static org.junit.Assert.*;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-20 16:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DailyCheckServiceImplTest {

    @Autowired
    DailyCheckService service;

    @Test
    public void checkDate() {

        System.out.println(service.checkDate(1));
        System.out.println(service.checkDate(2));

    }

    @Test
    public void checked(){
        System.out.println(service.checked(4));
    }



    @Test
    public void getCheckedDataList(){
        System.out.println(service.getCheckedDataList(1));
    }

    @Test
    public void getTotalCheckedDays(){
        System.out.println(service.getTotalCheckedDays(1));

    }

    @Test
    public void getTotalTrainingDays(){
        System.out.println(service.getTotalTrainingDays(1));
    }











}