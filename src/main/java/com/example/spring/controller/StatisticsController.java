package com.example.spring.controller;

import com.alibaba.fastjson.JSON;
import com.example.spring.apt.NotNullProcessTool;
import com.example.spring.exception.BizException;
import com.example.spring.model.RespBody;
import com.example.spring.model.StatisticsInfo;
import com.example.spring.model.enums.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics/")
public class StatisticsController {

    private Logger logger = LoggerFactory.getLogger(StatisticsController.class);

    @RequestMapping("get")
    public RespBody<String> get(StatisticsInfo statisticsInfo) {
        logger.info("receive request body:{}", JSON.toJSONString(statisticsInfo));
        try {
            NotNullProcessTool.checkParam(statisticsInfo);
            return new RespBody<>("success");
        } catch (BizException e) {
            return new RespBody<>(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return new RespBody<>(ErrorCode.SYS_ERROR);
        }
    }

}
