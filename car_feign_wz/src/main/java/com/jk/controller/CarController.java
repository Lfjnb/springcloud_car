package com.jk.controller;

import com.jk.pojo.AreaBean;
import com.jk.pojo.BrandBean;
import com.jk.pojo.CarBean;
import com.jk.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * 类描述：
 * 创建人：王政
 * 创建时间：2019/4/17 11:45
 * 修改人：wz
 * 修改时间：2019/4/17 11:45
 * 修改备注：
 */
@Controller
@RequestMapping("Car")
public class CarController {


    @Autowired
    private CarService carService;







    /**
     *  查询汽车总表
     */
    @RequestMapping("queryCar")
    @ResponseBody
    public HashMap<String,Object> queryCar(Integer page, Integer rows,CarBean carBean){
        HashMap<String,Object> map = carService.queryCar(page,rows,carBean);
        return map;
    }

    @RequestMapping("queryOuther")
    @ResponseBody
    public HashMap<String,Object> queryOuther(){
        return carService.queryOuther();
    }

}
