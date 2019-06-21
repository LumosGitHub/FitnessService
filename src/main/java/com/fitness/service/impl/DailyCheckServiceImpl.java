package com.fitness.service.impl;

import com.fitness.dao.DailyCheckDao;
import com.fitness.entity.DailyCheck;
import com.fitness.service.DailyCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-20 16:23
 */
@Service
public class DailyCheckServiceImpl implements DailyCheckService {


    @Autowired
    DailyCheckDao dao;


    @Override
    public boolean checkDate(Integer userId) {
        Integer result = dao.checkDate(userId);
        if (result == null) {
            return false;
        } else if (result.equals(1)) {
            return true;
        }
        return false;
    }


    /**
     * 添加当天打卡记录
     * @param userId
     * @return
     */
    @Transactional
    @Override
    public boolean checked(Integer userId) {
        if (dao.checked(userId).equals(1)){
            return true;
        }
        return false;
    }

    @Override
    public String getCheckedDataList(Integer userId) {
        List<Date> dailyChecks= dao.getDateList(userId);
        StringBuilder sb=new StringBuilder();
        for (Date d:dailyChecks){
            sb.append(d.toString()).append(",");
        }
        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - 1);
        }
        return "";
    }

    @Override
    public Integer getTotalCheckedDays(Integer userId) {
        return dao.getTotalCheckedDays(userId);
    }

    @Override
    public Integer getTotalTrainingDays(Integer userId) {
        return dao.getTotalTrainingDays(userId);
    }
}
