package com.fitness.service;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-21 10:45
 */
public interface TrainService {


    /**
     * 添加培训记录
     * @param userId
     * @param duration
     * @return
     */
    Integer addNewTrainRecord(Integer userId,Integer duration);

}
