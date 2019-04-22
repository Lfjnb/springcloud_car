package com.jk.service;


import com.jk.pojo.AppointmentBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("springcloud-car-reg")
public interface AppointmentService {
    @RequestMapping("app/Savexinxi")
    @ResponseBody
    void Savexinxi(@RequestBody AppointmentBean appointmentBean);
}
