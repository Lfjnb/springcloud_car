package com.jk.controller;

import com.jk.dao.DealDao;
import com.jk.pojo.AppointmentBean;
import com.jk.pojo.CarBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
         private DealDao dealDao;

         @Autowired
         private MongoTemplate mongoTemplate;

         @Autowired
         private RedisTemplate redisTemplate;

         @RequestMapping("CarSave")
         @ResponseBody
         public AppointmentBean  CarSave(@RequestBody AppointmentBean appointmen){
             return   mongoTemplate.save(appointmen);
        }

    /**
     * 车辆成交信息从mongodb取出来carid到mysql数据库查询车表展示到前台。
     * @return
     */
    @RequestMapping("queryDealCar")
    @ResponseBody
    public   List<CarBean>  queryDealCar(){
        List<CarBean> list = new ArrayList<>();
        Query query  =   new Query();
        List<AppointmentBean>  app  = mongoTemplate.find(query,AppointmentBean.class);
        for (int  i = 0; i<app.size(); i++) {
            Integer  carid  = app.get(i).getCarid();
            System.out.println(carid);
            CarBean carBeans =  dealDao.queryDealCar(carid);
            list.add((CarBean) carBeans);
        }
             return list;
    }
    /**
     * 回显汽车名字价格id
     * @param carid
     * @return
     */
    @RequestMapping("queryById")
    @ResponseBody
    public  CarBean   queryById(@RequestParam Integer  carid){
        return dealDao.queryByIdCar(carid);
    }

}
