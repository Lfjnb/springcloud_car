package com.jk.controller;


import com.jk.dao.EngineDao;
import com.jk.pojo.EngineBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EngineController {

    @Autowired
    private EngineDao engineDao;

    //根据carId查询发动机参数表
    @RequestMapping("queryEngine")
    @ResponseBody
    public List<EngineBean> queryEngine(@RequestParam Integer carId){
        return engineDao.queryEngine(carId);
    }

    //新增发动机参数表
    @RequestMapping("addEngine")
    @ResponseBody
    public Boolean addEngine(@RequestBody EngineBean engineBean){
        try{
            engineDao.addEngine(engineBean);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
