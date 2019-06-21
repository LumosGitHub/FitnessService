package com.fitness.controller;

import com.alibaba.fastjson.JSONArray;
import com.fitness.entity.NewsListItem;
import com.fitness.service.CommentService;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-21 16:38
 */
@RestController
public class CommentController {


    @Autowired
    CommentService service;


    /**
     * 根据用户id 获取当前用户所有评论
     * @param request
     * @return
     */
    @PostMapping("getCommentsList")
    @ResponseBody
    public String getCommentsList(HttpServletRequest request){
        String userId = request.getParameter("userId");
        List<NewsListItem> list = service.getCommentsList(Integer.parseInt(userId));
        return JSONArray.toJSONString(list);

    }

    /**
     * 添加评论
     * @param request
     * @return
     */
    @PostMapping("addNewComment")
    @ResponseBody
    public String addNewComment(HttpServletRequest request){
        String userId = request.getParameter("userId");
        String newsId = request.getParameter("newsId");
        String comment = request.getParameter("comment");
        String replyUser = request.getParameter("replyUser");
        if (service.addNewComment(Integer.parseInt(userId), Integer.parseInt(newsId), comment, replyUser)) {
            return "评论成功!";
        } else {
            return "error";
        }
    }


}
