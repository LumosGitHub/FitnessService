package com.fitness.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-20 22:51
 */
@Entity
@Table(name = "fitness_news")
public class News {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer newsId;

    private Integer userId;

    private String title;

    private String content;

    private String image;

    private Date releaseTime;

    private Integer status;


    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("News{");
        sb.append("newsId=").append(newsId);
        sb.append(", userId=").append(userId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", image='").append(image).append('\'');
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
