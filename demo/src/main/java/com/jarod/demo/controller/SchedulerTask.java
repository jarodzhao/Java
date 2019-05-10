package com.jarod.demo.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {
    private int count = 0;

    // 每隔十分钟执行一次（例："0 15 10 15 * ?" 每月15日上午10:15触发）
    @Scheduled(cron = "*/10 * * * * ?")
    private void process() {
        System.out.println("定时任务:" + count++);

    }
}
