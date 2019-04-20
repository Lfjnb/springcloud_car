package com.jk.controller;

import com.jk.dao.SellCarDao;
import com.jk.pojo.SellcarBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sell")
public class SellCarController {


    @Autowired
    private SellCarDao sellCarDao;

    /**
     * 新增卖车信息
     * @param sellcarBean
     * @return
     */
    @RequestMapping("addSellCar")
    @ResponseBody
    public  Boolean  addSellCar(@RequestBody SellcarBean sellcarBean){
        try {
            sellCarDao.addSellCar(sellcarBean);
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }
}
