package com.jk.controller;

import com.jk.pojo.InternalBean;
import com.jk.service.InternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class InternalController {

    @Autowired
    private InternalService internalService;

    //根据carId查询内部配置表
    @RequestMapping("queryInternal")
    @ResponseBody
    public List<InternalBean> queryInternal(Integer carId){
        return internalService.queryInternal(carId);
    }

    //新增内部配置表
    @RequestMapping("addInternal")
    @ResponseBody
    public Boolean addInternal(InternalBean internalBean){
        return internalService.addInternal(internalBean);
    }
}
