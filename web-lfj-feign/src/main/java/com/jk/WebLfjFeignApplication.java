package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients//识别项目中的feignClient的注解
public class WebLfjFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebLfjFeignApplication.class, args);
    }

}
