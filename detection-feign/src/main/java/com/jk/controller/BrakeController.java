package com.jk.controller;

import com.jk.pojo.BrakeBean;
import com.jk.service.BrakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BrakeController {

    @Autowired
    private BrakeService brakeService;

    //根据carId查询底盘及制动表
    @RequestMapping("queryBrake")
    @ResponseBody
    public List<BrakeBean> queryBrake(Integer carId){
        return brakeService.queryBrake(carId);
    }

    //新增底盘及制动表
    @RequestMapping("addBrake")
    @ResponseBody
    public Boolean addBrake(BrakeBean brakeBean){
        return brakeService.addBrake(brakeBean);
    }
}
