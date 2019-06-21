package com.fitness.controller;

import com.fitness.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-21 10:31
 */
@RestController
public class TrainController {

    @Autowired
    TrainService service;


    @PostMapping("addNewTrainRecord")
    @ResponseBody
    public String addNewTrainRecord(HttpServletRequest request){
        String userId = request.getParameter("userId");
        String duration = request.getParameter("duration");
        if (service.addNewTrainRecord(Integer.parseInt(userId), Integer.parseInt(duration))>0) {
            return "success";
        } else {
            return "error";
        }
    }

}
