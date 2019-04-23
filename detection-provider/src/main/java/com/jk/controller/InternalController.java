package com.jk.controller;

import com.jk.dao.InternalDao;
import com.jk.pojo.InternalBean;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class InternalController {

    @Autowired
    private InternalDao internalDao;

    //根据carId查询内部配置表
    @RequestMapping("queryInternal")
    @ResponseBody
    public List<InternalBean> queryInternal(@RequestParam Integer carId){
        return internalDao.queryInternal(carId);
    }

    //新增内部配置表
    @RequestMapping("addInternal")
    @ResponseBody
    public Boolean addInternal(@RequestBody InternalBean internalBean){
        try{
            internalDao.addInternal(internalBean);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
