package com.fitness.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-20 22:47
 */
@Entity
@Table(name = "fitness_favors")
public class Favors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer favorsId;
    private Integer userId;
    private Integer newsId;
    private Date favorsTime;
    private Integer status;


    public Integer getFavorsId() {
        return favorsId;
    }

    public void setFavorsId(Integer favorsId) {
        this.favorsId = favorsId;
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

    public Date getFavorsTime() {
        return favorsTime;
    }

    public void setFavorsTime(Date favorsTime) {
        this.favorsTime = favorsTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
