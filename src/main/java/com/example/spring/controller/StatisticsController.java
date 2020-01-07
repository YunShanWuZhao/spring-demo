package com.example.spring.controller;

import com.alibaba.fastjson.JSON;
import com.example.spring.apt.NotNullProcessTool;
import com.example.spring.exception.BizException;
import com.example.spring.model.RespBody;
import com.example.spring.model.StatisticsInfo;
import com.example.spring.model.enums.ErrorCode;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/statistics/")
public class StatisticsController {

    private Logger logger = LoggerFactory.getLogger(StatisticsController.class);

    @Resource
    RedissonClient redissonClient2;

    @RequestMapping("get")
    public RespBody<String> get(StatisticsInfo statisticsInfo) {
        logger.info("receive request body:{}", JSON.toJSONString(statisticsInfo));
        RBucket<Long> rBucket = redissonClient2.getBucket("test_redisson");
        rBucket.set(new Date().getTime());
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
