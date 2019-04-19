package com.jk.controller;

import com.jk.pojo.CarBean;
import com.jk.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * 类描述：
 * 创建人：王政
 * 创建时间：2019/4/18 14:03
 * 修改人：wz
 * 修改时间：2019/4/18 14:03
 * 修改备注：
 */
@Controller
public class CarController {


    @Autowired
    private CarService carService;

    /**
     *  查询汽车总表
     */
    @ResponseBody
    @RequestMapping("queryCar")
    HashMap<String,Object> queryCar(@RequestParam Integer page, @RequestParam Integer rows,@RequestBody CarBean carBean){
        HashMap<String,Object> map = carService.queryCar(page,rows,carBean);
        return map;
    }

    @RequestMapping("queryOuther")
    @ResponseBody
    public HashMap<String,Object> queryOuther(){
        return carService.queryOuther();
    }
}
