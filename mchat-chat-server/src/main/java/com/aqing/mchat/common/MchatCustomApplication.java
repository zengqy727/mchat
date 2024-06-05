package com.aqing.mchat.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zengqingyu
 * @date 2024/05/27
 */
@SpringBootApplication(scanBasePackages = {"com.aqing.mchat"})
@MapperScan({"com.aqing.mchat.common.**.mapper"})
public class MchatCustomApplication {

    public static void main(String[] args) {
        SpringApplication.run(MchatCustomApplication.class,args);
    }

}