package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("springcloud-car-reg")
public interface LoginService {

    //短信登录
    @RequestMapping("logina/quicklogin")
    @ResponseBody
    void addPhone(Long phone);

    //发送短信
    @RequestMapping("logina/finddunxian")
    @ResponseBody
    void add(@RequestParam("phone") Long phone);
}
