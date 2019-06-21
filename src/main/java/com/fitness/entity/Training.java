package com.fitness.entity;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-20 22:16
 */
@Entity
@Table(name = "fitness_training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Date trainTime;
    private Integer duration;
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getTrainTime() {
        return trainTime;
    }

    public void setTrainTime(Date trainTime) {
        this.trainTime = trainTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Training{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", trainTime=").append(trainTime);
        sb.append(", duration=").append(duration);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
