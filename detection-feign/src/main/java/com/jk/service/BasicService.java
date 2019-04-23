package com.jk.service;

import com.jk.pojo.BasicBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "detection-provider")
public interface BasicService {

    //根据carId查询基本参数表
    @RequestMapping("queryBasic")
    List<BasicBean> queryBasic(@RequestParam Integer carId);

    //新增基本参数表
    @RequestMapping("addBasic")
    Boolean addBasic(BasicBean basicBean);
}
