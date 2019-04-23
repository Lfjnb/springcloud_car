package com.jk.service;

import com.jk.model.CarBean2;
import com.jk.pojo.CarBean;
import com.jk.pojo.ImgsBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Scheduled;
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
     *  新增汽车总表
     *
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
    Boolean deleteCar(@PathVariable String id);

    /**
     * 根据Id查询单条汽车表的详情
     */
    @RequestMapping("queryCarById/{id}")
    HashMap<String, Object> queryCarById(@PathVariable Integer id);

    /**
     * 修改根据Id回显
     */
    @RequestMapping("findCarById/{id}")
    CarBean findCarById(@PathVariable Integer id);

    /**
     * 修改根据回显的Id
     */
    @RequestMapping("updateCarById")
    Boolean updateCarById(@RequestBody CarBean carBean);

    /**
     *
     * 查询Car表所有数据 缓存到ES
     */
    @RequestMapping("findCarListAll")
    List<CarBean2> findCarListAll();

    /**
     * 新增图片表
     */
    @RequestMapping("addImgs")
    Boolean addImgs(@RequestBody ImgsBean imgsBean);


    /**
     * 根据汽车Id 查询图片表
     */
    @RequestMapping("queryImgs/{id}")
    List<ImgsBean> queryImgs(@PathVariable Integer id);
}
