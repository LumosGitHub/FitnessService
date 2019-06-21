package com.fitness.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-21 19:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CommentControllerTest {


    MockMvc mockMvc;


    @Autowired
    protected WebApplicationContext wac;


    @Before()
    public void setup()
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }




    @Test
    public void getCommentsList() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/getCommentsList")
                .param("userId","1"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println("请求状态码：" + status);
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("接口返回结果：" + result);

    }

    @Test
    public void addNewComment() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/addNewComment")
                .param("userId","1")
                .param("newsId","1")
                .param("comment","python")
                .param("replyUser","python"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println("请求状态码：" + status);
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("接口返回结果：" + result);



    }
}