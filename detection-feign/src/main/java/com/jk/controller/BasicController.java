package com.jk.controller;

import com.jk.pojo.BasicBean;
import com.jk.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
public class BasicController {

    @Autowired
    private BasicService basicService;

    //根据carId查询基本参数表
    @RequestMapping("queryBasic")
    @ResponseBody
    public List<BasicBean> queryBasic(Integer carId){
        return basicService.queryBasic(carId);
    }

    //新增基本参数表
    @RequestMapping("addBasic")
    @ResponseBody
    public Boolean addBasic(BasicBean basicBean){
        return basicService.addBasic(basicBean);
    }

}
