package com.jk.service;

import com.jk.pojo.SellcarBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@FeignClient("springcloud-car-reg")
public interface SellcarService {

    @RequestMapping("sell/addSellCar")
    @ResponseBody
    Boolean  addSellCar(@RequestBody SellcarBean sellcarBean);

    @RequestMapping("sell/querySellCar")
    @ResponseBody
    HashMap<String, Object> querySellCar(@RequestParam Integer page,@RequestParam Integer rows,@RequestBody SellcarBean sellcarBean);
}
