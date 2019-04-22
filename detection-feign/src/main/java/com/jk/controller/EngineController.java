package com.jk.controller;


import com.jk.pojo.EngineBean;
import com.jk.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EngineController {

    @Autowired
    private EngineService engineService;

    //根据carId查询发动机参数表
    @RequestMapping("queryEngine")
    @ResponseBody
    public List<EngineBean> queryEngine(Integer carId){
        return engineService.queryEngine(carId);
    }

    //新增发动机参数表
    @RequestMapping("addEngine")
    @ResponseBody
    public Boolean addEngine(EngineBean engineBean){
        return engineService.addEngine(engineBean);
    }
}
