package com.jk.service;

import com.jk.pojo.AreaBean;
import com.jk.pojo.CarBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * 类描述：
 * 创建人：王政
 * 创建时间：2019/4/17 11:47
 * 修改人：wz
 * 修改时间：2019/4/17 11:47
 * 修改备注：
 */
@FeignClient(value = "car-provider-wz")
public interface CarService {




    /**
     *  查询汽车总表
     */
    @RequestMapping("queryCar")
    HashMap<String,Object> queryCar(@RequestParam Integer page, @RequestParam Integer rows,@RequestBody CarBean carBean);

    @RequestMapping("queryOuther")
    HashMap<String, Object> queryOuther();
}
