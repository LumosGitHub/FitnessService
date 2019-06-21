package com.fitness.dao;

import com.fitness.entity.DailyCheck;
import com.fitness.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-20 15:56
 */
public interface DailyCheckDao extends JpaRepository<User, Integer> {


    /**
     * 添加当天打卡记录
     * @param userId
     * @return
     */
    @Modifying
    @Query(value = "INSERT INTO fitness_daily_check (user_id, check_date,check_time ) VALUES (:userId, CURDATE(), CURRENT_TIME())",nativeQuery = true)
    Integer checked(@Param("userId") Integer userId);

    /**
     * 查询当天是否打卡
     * @param userId
     * @return
     */
    @Query(value = "SELECT id FROM fitness_daily_check WHERE user_id = :userId AND check_date = CURDATE()",nativeQuery = true)
    Integer checkDate(@Param("userId") Integer userId);

    /**
     * 根据用户id获取全部打卡记录
     * @param userId
     * @return
     */
    @Query(value = "select current_date from fitness_training where user_id= :userId",nativeQuery = true)
    List<Date> getDateList(@Param("userId") Integer userId);


    @Query(value = "select  count(1) from fitness_daily_check where user_id=:userId",nativeQuery = true)
    Integer getTotalCheckedDays(@Param("userId") Integer userId);

    @Query(value = "SELECT IFNULL(SUM(duration),0) FROM fitness_training WHERE user_id = :userId",nativeQuery = true)
    Integer getTotalTrainingDays(@Param("userId") Integer userId);


}
