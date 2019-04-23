package com.jk.controller;

import com.jk.dao.SellCarDao;
import com.jk.pojo.CarBean;
import com.jk.pojo.SellcarBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

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

    /**
     * 卖车信息查询
     */
    @RequestMapping("querySellCar")
    @ResponseBody
    public HashMap<String , Object> querySellCar(@RequestParam Integer  page,@RequestParam Integer  rows,@RequestBody SellcarBean sellcarBean){

        HashMap<String, Object> map = new HashMap<>();

        map.put("sellcarBean", sellcarBean);
        int  total = sellCarDao.findCount(map);
        Integer  start = (page-1)*rows;
        map.put("start", start);
        map.put("rows", rows);
        List<SellcarBean> list = sellCarDao.findlist(map);
        map.put("total", total);
        map.put("rows", list);
        return map;
    }
}
