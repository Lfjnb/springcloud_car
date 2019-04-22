package com.jk.service;

import com.jk.pojo.EngineBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "detection-provider")
public interface EngineService {

    //根据carId查询发动机参数表
    @RequestMapping("queryEngine")
    List<EngineBean> queryEngine(@RequestParam Integer carId);

    //新增发动机参数表
    @RequestMapping("addEngine")
    Boolean addEngine(EngineBean engineBean);
}
