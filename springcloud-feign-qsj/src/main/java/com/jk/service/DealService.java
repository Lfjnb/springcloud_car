package com.jk.service;

import com.jk.pojo.AppointmentBean;
import com.jk.pojo.CarBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@FeignClient("springcloud-car-reg")
public interface DealService {

    @RequestMapping("deal/CarSave")
    @ResponseBody
    AppointmentBean CarSave(@RequestBody AppointmentBean appointmentBean);


    @RequestMapping("deal/queryDealCar")
    @ResponseBody
    HashMap<String, Object> queryDealCar();

}
