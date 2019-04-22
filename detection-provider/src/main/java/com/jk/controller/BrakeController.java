package com.jk.controller;

import com.jk.dao.BrakeDao;
import com.jk.pojo.BrakeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BrakeController {

    @Autowired
    private BrakeDao brakeDao;

    //根据carId查询底盘及制动表
    @RequestMapping("queryBrake")
    @ResponseBody
    public List<BrakeBean> queryBrake(@RequestParam Integer carId){
        return brakeDao.queryBrake(carId);
    }

    //新增底盘及制动表
    @RequestMapping("addBrake")
    @ResponseBody
    public Boolean addBrake(@RequestBody BrakeBean brakeBean){
        try{
            brakeDao.addBrake(brakeBean);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
