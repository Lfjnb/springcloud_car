package com.jk.dao;

import com.jk.model.CarBean2;
import com.jk.pojo.CarBean;
import com.jk.pojo.DictionaryBean;
import com.jk.pojo.ImgsBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    long queryCount( CarBean carBean);
    /**
     *  查询汽车总表
     */
    List<CarBean> queryCar( long start, Integer rows,@Param("carBean") CarBean carBean);

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

    //查询字典表车 排量标准
    @Select("SELECT *  FROM t_dictionary where codepid=1006")
    List<DictionaryBean> queryEmissionStandard();

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
    List<DictionaryBean> queryNation();

    //查询字典表车 亮点配置
    @Select("SELECT *  FROM t_dictionary where codepid=1013")
    List<DictionaryBean> queryConfiguration();

    //查询字典表车 标签
    @Select("SELECT *  FROM t_dictionary where codepid=1014")
    List<DictionaryBean> queryLabel();



    // 新增汽车表
    int addCar(CarBean carBean);

    /**
     *
     * 随机查询 12 张汽车数据
     */
    List<CarBean> queryCarRandom();

    /**
     *
     *  根据前台Id 删除汽车表
     *
     * @param split
     */
    int deleteCar(String[] split);


    @Select("SELECT imgurl from t_imgs where id=(\n" +
            "\t\tSELECT max(id) from t_imgs WHERE carId=(\n" +
            "\t\tSELECT carid FROM t_imgs WHERE carid=#{carid} GROUP BY carid)) ")
    String queryImgsById(Integer carid);

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
    int updateCarById(CarBean carBean);

    /**
     *
     * 查询Car表所有数据 缓存到ES
     */
    List<CarBean2> findCarListAll();

    /**
     * 新增图片表
     */
    int addImgs(ImgsBean imgsBean);

    /**
     * 根据汽车Id 查询图片表
     */
    List<ImgsBean> queryImgs(Integer id);
}
