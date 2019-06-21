package com.fitness.service;



import com.fitness.entity.NewsListItem;

import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-21 16:46
 */
public interface CommentService {


    /**
     * 获取当前用户所有评论
     * @param userId
     * @return
     */
     List<NewsListItem> getCommentsList(Integer userId);

    /**
     * 添加评论
     * @param userId
     * @param newsId
     * @param comment
     * @param replyUser
     * @return
     */
    boolean addNewComment(Integer userId, Integer newsId, String comment, String replyUser);

}
