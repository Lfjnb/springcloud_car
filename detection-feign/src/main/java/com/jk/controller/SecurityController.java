package com.jk.controller;

import com.jk.pojo.SecurityBean;
import com.jk.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SecurityController {

    @Autowired
    private SecurityService securityService;

    //根据carId查询安全配置表
    @RequestMapping("querySecurity")
    @ResponseBody
    public List<SecurityBean> querySecurity(Integer carId){
        return securityService.querySecurity(carId);
    }

    //新增安全配置表
    @RequestMapping("addSecurity")
    @ResponseBody
    public Boolean addSecurity(SecurityBean securityBean){
        return securityService.addSecurity(securityBean);
    }
}
