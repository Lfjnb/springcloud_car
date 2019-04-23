package com.jk.controller;


import com.jk.constantconf.ConstantConf;
import com.jk.pojo.AppointmentBean;
import com.jk.pojo.CarBean;
import com.jk.pojo.SellcarBean;
import com.jk.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("deal")
public class DealCompleteController {
    /**
     * 车辆成交信息存在mongodb里
     *
     */
    @Autowired
    private DealService dealService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("CarSave")
    @ResponseBody
    public AppointmentBean CarSave(AppointmentBean appointmentBean,HttpServletRequest request){

        Date date = new Date();
        Integer   id  = (int)date.getTime();
        HttpSession session = request.getSession();
        Object  phone  =  session.getAttribute(session.getId());
        System.out.println(phone);
        Object  attribute  = redisTemplate.opsForValue().get(ConstantConf.SMS_LOGIN_PHONE+phone);
        /*AppointmentBean appointmen =   new AppointmentBean();
        appointmen.setId(id);
        appointmen.setLookcartime("2019-02-03");
        appointmen.setArea(2);
        appointmen.setCarid(3);
        appointmen.setStatus(1);*/
        appointmentBean.setId(id);
        appointmentBean.setPhone(phone.toString());
        return  dealService.CarSave(appointmentBean);

    }

    @RequestMapping("queryDealCar")
    @ResponseBody
    public  List<CarBean>  queryDealCar(){
       // stringObjectHashMap =
       /* List<CarBean> carBeans = new ArrayList<>();
        for (int i=0;i<stringObjectHashMap.size();i++){
            List<CarBean> o = (List<CarBean>) stringObjectHashMap.get("carBean" + i);
        }*/



        return  dealService.queryDealCar();
    }


}
