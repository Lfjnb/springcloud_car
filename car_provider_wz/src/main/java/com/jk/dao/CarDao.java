package com.jk.dao;

import com.jk.pojo.CarBean;
import com.jk.pojo.DictionaryBean;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述：
 * 创建人：王政
 * 创建时间：2019/4/18 14:05
 * 修改人：wz
 * 修改时间：2019/4/18 14:05
 * 修改备注：
 */
public interface CarDao {
    /**
     *  查询汽车总表总条数
     */
    long queryCount(CarBean carBean);
    /**
     *  查询汽车总表
     */
    List<CarBean> queryCar(long start, Integer rows, CarBean carBean);

    //查询字典表车 颜色
    @Select("SELECT *  FROM t_dictionary where codepid=1009")
    List<DictionaryBean> queryColor();
    //查询字典表车 车型
    @Select("SELECT *  FROM t_dictionary where codepid=1003")
    List<DictionaryBean> queryCarModel();

    //查询字典表车 车龄
    @Select("SELECT *  FROM t_dictionary where codepid=1001")
    List<DictionaryBean> queryCarAge();

    //查询字典表车 变速箱
    @Select("SELECT *  FROM t_dictionary where codepid=1002")
    List<DictionaryBean> queryGearbox();

    //查询字典表车 里程
    @Select("SELECT *  FROM t_dictionary where codepid=1004")
    List<DictionaryBean> queryMileage();

    //查询字典表车 排量
    @Select("SELECT *  FROM t_dictionary where codepid=1005")
    List<DictionaryBean> queryCer();

    //查询字典表车 座位数
    @Select("SELECT *  FROM t_dictionary where codepid=1007")
    List<DictionaryBean> queryCarSeat();

    //查询字典表车 燃油类型
    @Select("SELECT *  FROM t_dictionary where codepid=1008")
    List<DictionaryBean> queryCarFuel();

    //查询字典表车 车牌所在地
    @Select("SELECT *  FROM t_dictionary where codepid=1010")
    List<DictionaryBean> queryLicense();

    //查询字典表车 驱动类型
    @Select("SELECT *  FROM t_dictionary where codepid=1011")
    List<DictionaryBean> queryDrive();

    //查询字典表车 国别
    @Select("SELECT *  FROM t_dictionary where codepid=1012")
    Object queryNation();
}
