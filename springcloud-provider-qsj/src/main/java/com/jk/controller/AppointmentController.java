package com.jk.controller;


import com.jk.constantconf.ConstantConf;
import com.jk.dao.AppointmentDao;
import com.jk.pojo.AppointmentBean;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("app")
public class AppointmentController {
     @Autowired
     private AppointmentDao appointmentDao;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 预约看车信息将信息存在数据库中
     * @param appointmentBean
     * @return
     */
      @RequestMapping("Savexinxi")
      @ResponseBody
      public Boolean  Savexinxi (@RequestBody AppointmentBean appointmentBean){
              try{


                  //将redis中的登录用户手机号取出来存在mysql表里
                  appointmentDao.Savexinxi(appointmentBean);


                  return  true;
              }catch (Exception e){
                  e.printStackTrace();
                  return  false;
              }

      }
}
