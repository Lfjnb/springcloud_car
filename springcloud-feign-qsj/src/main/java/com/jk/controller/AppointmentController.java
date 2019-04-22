package com.jk.controller;

import com.jk.constantconf.ConstantConf;
import com.jk.pojo.AppointmentBean;
import com.jk.service.AppointmentService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("app")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 预约看车信息将信息存在数据库中
     * @param appointmentBean
     * @return
     */
    @RequestMapping("Savexinxi")
    @ResponseBody
    public Boolean  Savexinxi (AppointmentBean appointmentBean,HttpServletRequest request){
        try{
            //将redis中的登录用户手机号取出来存在mysql表里
            HttpSession session = request.getSession();
           Object  phone  =  session.getAttribute(session.getId());
            System.out.println(phone);
            Object attribute = redisTemplate.opsForValue().get(ConstantConf.SMS_LOGIN_PHONE+phone.toString());
            System.out.println(attribute);
            appointmentBean.setPhone(attribute.toString());
            appointmentService.Savexinxi(appointmentBean);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }

    }


}
