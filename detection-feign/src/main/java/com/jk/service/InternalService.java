package com.jk.service;

import com.jk.pojo.InternalBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "detection-provider")
public interface InternalService {


    //根据carId查询内部配置表
    @RequestMapping("queryInternal")
    List<InternalBean> queryInternal(@RequestParam Integer carId);

    //新增内部配置表
    @RequestMapping("addInternal")
    Boolean addInternal(InternalBean internalBean);
}
