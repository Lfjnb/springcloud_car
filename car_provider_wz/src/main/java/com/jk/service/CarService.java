package com.jk.service;

import com.jk.pojo.CarBean;

import java.util.HashMap;

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

    HashMap<String, Object> queryOuther();
}
