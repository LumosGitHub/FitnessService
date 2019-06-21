package com.fitness.service.impl;

import com.fitness.dao.TrainDao;
import com.fitness.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-21 10:45
 */
@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    TrainDao dao;

    @Transactional
    @Override
    public Integer addNewTrainRecord(Integer userId, Integer duration) {
        return dao.addNewTrainRecord(userId, duration);
    }
}
