package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jk.constantconf.ConstantConf;
import com.jk.dao.RecordDao;
import com.jk.pojo.CarBean;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("record")
public class LookRecordController {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RecordDao recordDao;

    /**
     * 浏览汽车记录新增
     * @param carid
     * @param phonee
     * @return
     */

    @RequestMapping("saveRecord")
    @ResponseBody
    public List<CarBean>  saveRecord(@RequestParam Integer  carid,@RequestParam String phonee){

            List<CarBean> carBeans = recordDao.saveRecord(carid);

            redisTemplate.opsForList().leftPush(ConstantConf.SMS_LOOK_RECORD_CAR+phonee,carBeans);
            return  carBeans;


    }

    /**
     * 查询
     * @param phonee
     * @return
     */

    @RequestMapping("queryRecord")
    @ResponseBody
    public  List<CarBean>  queryRecord(@RequestParam String  phonee){

        List<Object> range = redisTemplate.opsForList().range(ConstantConf.SMS_LOOK_RECORD_CAR + phonee, 0, -1);
        List<CarBean> list = new ArrayList();
        for (int i = 0; i < range.size(); i++) {
            list.addAll((Collection<? extends CarBean>) range.get(i));
        }

        return list;
    }

}
