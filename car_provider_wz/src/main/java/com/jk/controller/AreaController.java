package com.jk.controller;

import com.jk.pojo.AreaBean;
import com.jk.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 类描述：
 * 创建人：王政
 * 创建时间：2019/4/18 18:38
 * 修改人：wz
 * 修改时间：2019/4/18 18:38
 * 修改备注：
 */
@Controller
public class AreaController {


    @Autowired
    private AreaService areaService;

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 查询地区表
     */
    @RequestMapping("queryArea")
    @ResponseBody
    public List<AreaBean> queryArea(){

        String rediskay = "queryArea"+1;
        Boolean hasKey = redisTemplate.hasKey(rediskay);

        if(hasKey){
            System.out.println("走缓存！！！！！！！！！！！！");
            List<AreaBean> range = redisTemplate.opsForList().range("queryArea" + 1, 0, -1);
            return range;
        }
        else {
            System.out.println("走数据库！！！！！！！！！！！！");

            List<AreaBean> list = areaService.queryArea();
            for (int i = 0; i < list.size(); i++){
                redisTemplate.opsForList().leftPush("queryArea" + 1,list.get(i));
            }
            return list;
        }
    }



}
