package com.jk.service;

import com.jk.pojo.ExternalBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "detection-provider")
public interface ExternalService {

    //根据carId查询外部配置表
    @RequestMapping("queryExternal")
    List<ExternalBean> queryExternal(@RequestParam Integer carId);

    @RequestMapping("addExternal")
    Boolean addExternal(ExternalBean externalBean);
}
