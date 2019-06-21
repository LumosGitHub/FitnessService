package com.fitness.controller;

import com.fitness.service.DailyCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-20 15:52
 */
@RestController
public class DailyCheckController {
    String ERROR = "{'info':'error'}";
    @Autowired
    DailyCheckService service;

    /**
     * 新增当天打卡
     *
     * @param request
     * @return
     */
    @PostMapping("checkCondition")
    @ResponseBody
    public String checkCondition(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        boolean result = service.checkDate(Integer.parseInt(userId));

        if (result) {
            return "您今日已经打过卡了，无需再次打卡";
        } else {
            if (service.checked(Integer.parseInt(userId))) {
                return "success";
            } else {
                return "暂时无法打卡";
            }
        }
    }

    /**
     * 获取当前用户所有打卡日期
     *
     * @param request
     * @return
     */
    @PostMapping("getCheckedList")
    @ResponseBody
    public String getCheckedList(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        String checkedList = service.getCheckedDataList(Integer.parseInt(userId));
        if (checkedList == null) {
            return ERROR;
        } else {
            return checkedList;
        }

    }

    /**
     * @param request
     * @return
     */
    @PostMapping("getHomepageTotalRecord")
    @ResponseBody
    public String getHomepageTotalRecord(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        int checkedDays = service.getTotalCheckedDays(Integer.parseInt(userId));
        int trainingDays = service.getTotalTrainingDays(Integer.parseInt(userId));
        return checkedDays + ":" + trainingDays;
    }


}
