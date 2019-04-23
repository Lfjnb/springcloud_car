package com.jk.controller;

import com.jk.dao.BasicDao;
import com.jk.pojo.BasicBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BasicController {

    @Autowired
    private BasicDao basicDao;

    //根据carId查询基本参数表
    @RequestMapping("queryBasic")
    @ResponseBody
    public List<BasicBean> queryBasic(@RequestParam Integer carId){
        return basicDao.queryBasic(carId);
    }

    //新增基本参数表
    @RequestMapping("addBasic")
    @ResponseBody
    public Boolean addBasic(@RequestBody BasicBean basicBean){
        try{
            basicDao.addBasic(basicBean);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
