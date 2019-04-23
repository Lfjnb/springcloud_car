package com.jk.controller;

import com.jk.pojo.SellcarBean;
import com.jk.service.SellcarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("sell")
public class CarSellController {

    @Autowired
    private SellcarService sellcarService;

    /**
     * 新增卖车信息
     * @param sellcarBean
     * @return
     */
    @RequestMapping("addSellCar")
    @ResponseBody
    public  Boolean  addSellCar(SellcarBean sellcarBean){
        return sellcarService.addSellCar(sellcarBean);
    }


    /**
     * 卖车查询
     */
    @RequestMapping("querySellCar")
    @ResponseBody
    public HashMap<String , Object> querySellCar(Integer  page,Integer  rows,SellcarBean sellcarBean){

        return  sellcarService.querySellCar(page,rows,sellcarBean);
    }
}
