package com.jk.controller;


import com.jk.constantconf.ConstantConf;
import com.jk.pojo.CarBean;
import com.jk.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("record")
public class LookRecordController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RecordService recordService;

    /**
     * 浏览汽车记录新增
     * @param carid
     * @param request
     * @return
     */

    @RequestMapping("saveRecord")
    @ResponseBody
        public List<CarBean>  saveRecord(@RequestParam Integer  carid, HttpServletRequest request){
           HttpSession session = request.getSession();
            Object  phone  =  session.getAttribute(session.getId());
            System.out.println(phone);
           String  phonee = phone.toString();
            return  recordService.saveRecord(carid,phonee);
        }


    /**
     * 查询
     * @param request
     * @return
     */
    @RequestMapping("queryRecord")
    @ResponseBody
    public  List<CarBean>  queryRecord(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object  phone  =  session.getAttribute(session.getId());
        System.out.println(phone);
        String  phonee  = phone.toString();
        return  recordService.queryRecord(phonee);
    }


}
