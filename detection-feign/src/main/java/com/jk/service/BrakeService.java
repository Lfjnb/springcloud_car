package com.jk.service;

import com.jk.pojo.BrakeBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "detection-provider")
public interface BrakeService {

    //根据carId查询底盘及制动表
    @RequestMapping("queryBrake")
    List<BrakeBean> queryBrake(@RequestParam Integer carId);

    //新增底盘及制动表
    @RequestMapping("addBrake")
    Boolean addBrake(BrakeBean brakeBean);
}
