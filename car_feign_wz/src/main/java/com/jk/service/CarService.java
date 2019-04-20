package com.jk.service;

import com.jk.pojo.CarBean;
import com.jk.pojo.ImgsBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    /**
     *  查询汽车其它配件表
     */
    @RequestMapping("queryOuther")
    HashMap<String, Object> queryOuther();

    /**
     *
     *  新增汽车总表和汽车图片表
     *  根据汽车总表id
     */
    @RequestMapping("addCar")
    Boolean addCar(@RequestBody CarBean carBean);


    /**
     *
     * 随机查询 12 张汽车数据
     */
    @RequestMapping("queryCarRandom")
    List<CarBean> queryCarRandom();

    /**
     *
     *  根据前台Id 删除汽车表
     *
     */
    @RequestMapping("deleteCar/{id}")
    Boolean deleteCar(@PathVariable Integer id);
}
