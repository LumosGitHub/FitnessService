package com.fitness.service;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-20 16:22
 */
public interface DailyCheckService {


    /**
     * 检查当天是否打卡
     * @param userId
     * @return
     */
    boolean checkDate(Integer userId);

    /**
     * 添加打开记录
     * @param userId
     * @return
     */
    boolean checked(Integer userId);

    /**
     * 根据用户id，获取当前用户所有打卡的日期
     * @param userId
     * @return
     */
    String getCheckedDataList(Integer userId);

    /**
     * 获取全部 打卡总记录数
     * @param userId
     * @return
     */
    Integer getTotalCheckedDays(Integer userId);

    Integer getTotalTrainingDays(Integer userId);


}
