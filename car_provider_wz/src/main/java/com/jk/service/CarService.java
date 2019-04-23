package com.jk.service;

import com.jk.model.CarBean2;
import com.jk.pojo.CarBean;
import com.jk.pojo.ImgsBean;

import java.util.HashMap;
import java.util.List;

/**
 * 类描述：
 * 创建人：王政
 * 创建时间：2019/4/18 14:04
 * 修改人：wz
 * 修改时间：2019/4/18 14:04
 * 修改备注：
 */
public interface CarService {
    /**
     *  查询汽车总表
     */
    HashMap<String, Object> queryCar(Integer page, Integer rows, CarBean carBean);
    /**
     *
     *  查询字典表的所有 类型
     */
    HashMap<String, Object> queryOuther();
    //新增汽车表
    Boolean addCar(CarBean carBean);
    /**
     *
     * 随机查询 12 张汽车数据
     */
    List<CarBean> queryCarRandom();
    /**
     *
     *  根据前台Id 删除汽车表
     *
     */

    Boolean deleteCar(String id);
    /**
     * 根据Id查询单条汽车表的详情
     */
    List<CarBean> queryCarById(Integer id);

    /**
     * 根据Id查询单条汽车图片的详情
     */
    List<ImgsBean> queryImgById(Integer id);

    /**
     * 修改根据Id回显
     */
    CarBean findCarById(Integer id);

    /**
     * 修改根据回显的Id
     */
    Boolean updateCarById(CarBean carBean);

    /**
     *
     * 查询Car表所有数据 缓存到ES
     */
    List<CarBean2> findCarListAll();

    /**
     * 新增图片表
     */
    Boolean addImgs(ImgsBean imgsBean);

    /**
     * 根据汽车Id 查询图片表
     */
    List<ImgsBean> queryImgs(Integer id);
}
