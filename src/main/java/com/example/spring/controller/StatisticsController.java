package com.example.spring.controller;

import com.alibaba.fastjson.JSON;
import com.example.spring.apt.NotNullProcessTool;
import com.example.spring.model.StatisticsInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics/")
public class StatisticsController {

    private Logger logger = LoggerFactory.getLogger(StatisticsController.class);

    @RequestMapping("get")
    public String get(StatisticsInfo statisticsInfo){
        logger.info("receive request body:{}", JSON.toJSONString(statisticsInfo));
        NotNullProcessTool.checkParam(statisticsInfo);
        return "success";
    }

}
