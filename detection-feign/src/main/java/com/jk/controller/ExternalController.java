package com.jk.controller;

import com.jk.pojo.ExternalBean;
import com.jk.service.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ExternalController {

    @Autowired
    private ExternalService externalService;

    //根据carId查询外部配置表
    @RequestMapping("queryExternal")
    @ResponseBody
    public List<ExternalBean> queryExternal(Integer carId){
        return externalService.queryExternal(carId);
    }

    //新增外部配置表
    @RequestMapping("addExternal")
    @ResponseBody
    public Boolean addExternal(ExternalBean externalBean){
        return externalService.addExternal(externalBean);
    }
}
