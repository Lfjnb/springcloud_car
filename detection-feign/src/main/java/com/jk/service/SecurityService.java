package com.jk.service;

import com.jk.pojo.SecurityBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "detection-provider")
public interface SecurityService {

    //根据carId查询安全配置表
    @RequestMapping("querySecurity")
    List<SecurityBean> querySecurity(@RequestParam Integer carId);

    //新增安全配置表
    @RequestMapping("addSecurity")
    Boolean addSecurity(SecurityBean securityBean);
}
