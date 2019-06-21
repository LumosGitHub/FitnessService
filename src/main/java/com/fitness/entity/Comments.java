package com.fitness.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-20 22:29
 */
@Entity
@Table(name = "fitness_comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    private Integer userId;
    private Integer newsId;
    private String comment;
    private String replyUser;
    private Date commentTime;
    private Integer status;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getReplyUser() {
        return replyUser;
    }

    public void setReplyUser(String replyUser) {
        this.replyUser = replyUser;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Comments{");
        sb.append("commentId=").append(commentId);
        sb.append(", userId=").append(userId);
        sb.append(", newsId=").append(newsId);
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", replyUser='").append(replyUser).append('\'');
        sb.append(", commentTime=").append(commentTime);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
