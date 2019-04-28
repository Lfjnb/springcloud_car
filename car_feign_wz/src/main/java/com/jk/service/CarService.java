package com.jk.service;

import com.jk.model.CarBean2;
import com.jk.pojo.CarBean;
import com.jk.pojo.CarBean1;
import com.jk.pojo.ImgsBean;
import com.jk.utils.ResultUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

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
    HashMap<String,Object> queryCar(@RequestParam Integer page, @RequestParam Integer rows, @RequestBody CarBean carBean);
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

    /**
     * 根据汽车Id 1.修改成交价格 2.并录入交易信息到mongdo数据库 3.删除本ID汽车
     * 杨恩博，只加方法，不改其他地方，我的方法 注释里都写入我的名字
     */
    @RequestMapping("updatePrice")
    Boolean updatePrice(@RequestBody CarBean carBean);

    @RequestMapping("findSellCar/{day}")
    List<CarBean1> findSellCar(@PathVariable Integer day);

    /**
     * 用户看车记录查询
     * 杨恩博
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("findUserCar")
    @ResponseBody
    ResultUtil findUserCar(@RequestParam Integer page, @RequestParam Integer rows);
}
