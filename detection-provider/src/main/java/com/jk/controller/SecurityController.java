package com.jk.controller;

import com.jk.dao.SecurityDao;
import com.jk.pojo.SecurityBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SecurityController {

    @Autowired
    private SecurityDao securityDao;


    //根据carId查询安全配置表
    @RequestMapping("querySecurity")
    @ResponseBody
    public List<SecurityBean> querySecurity(@RequestParam Integer carId){
        return securityDao.querySecurity(carId);
    }

    //新增安全配置表
    @RequestMapping("addSecurity")
    @ResponseBody
    public Boolean addSecurity(@RequestBody SecurityBean securityBean){
        try{
            securityDao.addSecurity(securityBean);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
