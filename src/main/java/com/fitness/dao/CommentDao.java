package com.fitness.dao;


import com.fitness.entity.Comments;
import com.fitness.entity.NewsListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-21 16:43
 */

public interface CommentDao extends JpaRepository<NewsListItem, Integer> {


    /**
     * 根据用户id查询评论。多表查询
     * @param userId
     * @return
     */
    @Query(value = "SELECT  c.news_id  , title, username FROM fitness_user a, fitness_news b, fitness_comments c WHERE c.user_id = :userId AND c.news_id = b.news_id AND b.user_id = a.user_id",nativeQuery = true)
     List<Object[]> getCommentsList(@Param("userId") Integer userId);


    /**
     * 添加评论
     * @param userId
     * @param newsId
     * @param comment
     * @param replyUser
     * @return
     */
    @Modifying
    @Query(value = "INSERT INTO comments (newsId, userId, comment, replyUser) VALUES (:userId, :newsId, :comment, :replyUser)",nativeQuery = true)
    Integer addNewComment(@Param("userId") Integer userId, @Param("newsId")Integer newsId, @Param("comment")String comment, @Param("replyUser")String replyUser);







}
