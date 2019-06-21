package com.fitness.dao;

import com.fitness.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-21 10:37
 */
public interface TrainDao extends JpaRepository<Training, Integer> {

    @Modifying
    @Query(value = "INSERT INTO fitness_training (user_id, duration) VALUES (:userId, :duration)",nativeQuery = true)
    Integer addNewTrainRecord(@Param("userId") Integer userId, @Param("duration") Integer duration);

}
