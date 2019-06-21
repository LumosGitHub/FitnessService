package com.fitness.service.impl;

import com.fitness.entity.NewsListItem;
import com.fitness.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-21 16:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceImplTest {


    @Autowired
    CommentService service;

    @Test
    public void getCommentsList() throws Exception {


        List<NewsListItem> testViews = service.getCommentsList(3);

        System.out.println(testViews);
    }

    @Test
    public void addNewComment(){
        System.out.println(service.addNewComment(1, 1, "java", "java"));
    }





}