package com.jk.controller;

import com.jk.dao.ExternalDao;
import com.jk.pojo.ExternalBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ExternalController {

    @Autowired
    private ExternalDao externalDao;

    //根据carId查询外部配置表
    @RequestMapping("queryExternal")
    @ResponseBody
    public List<ExternalBean> queryExternal(@RequestParam Integer carId){
        return externalDao.queryExternal(carId);
    }

    //新增外部配置表
    @RequestMapping("addExternal")
    @ResponseBody
    public Boolean addExternal(@RequestBody ExternalBean externalBean){
        try{
            externalDao.addExternal(externalBean);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
