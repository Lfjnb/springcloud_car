package com.jk.dao;

import com.jk.model.CarBean2;
import com.jk.pojo.AppotionBean;
import com.jk.pojo.CarBean;
import com.jk.pojo.DictionaryBean;
import com.jk.pojo.ImgsBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
    long queryCount(HashMap<String,Object> paramert);
    /**
     *  查询汽车总表
     */
    List<CarBean> queryCar(HashMap<String,Object> paramert);

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

    /**
     * 根据汽车Id 1.修改成交价格 2.并录入交易信息到mongdo数据库 3.删除本ID汽车
     * 杨恩博，只加方法，不改其他地方，我的方法 注释里都写入我的名字
     */
    @Update("update t_car set price = #{price} where id = #{id}")
    int updatePrice(CarBean carBean);

    /**
     * 根据汽车Id 1.修改成交价格 2.并录入交易信息到mongdo数据库 3.删除本ID汽车
     * 杨恩博，只加方法，不改其他地方，我的方法 注释里都写入我的名字
     */
    @Delete("delete from t_car where id = #{id}")
    void deleteCarYangEb(Integer id);

    /**
     * 根据汽车Id 1.修改成交价格 2.并录入交易信息到mongdo数据库 3.删除本ID汽车
     * 杨恩博，只加方法，不改其他地方，我的方法 注释里都写入我的名字
     */
    CarBean findCarById2(Integer id);

    /**
     * 用户看车记录查询
     * 杨恩博
     * @param page
     * @param rows
     * @return
     */
    @Select("SELECT\n" +
            "\tt.id,\n" +
            "\tt.lookcartime ,\n" +
            "\tt.phone,\n" +
            "\ttc.ownerId,\n" +
            "\ttc.id as carId,\n" +
            "\ttb.brandName,\n" +
            "\tts.seriesName\n" +
            "\tFROM\n" +
            "\tt_appointment t\n" +
            "\tLEFT JOIN t_car tc ON t.carid = tc.id\n" +
            "\tLEFT JOIN t_brand  tb on  tc.brandId=tb.id\n" +
            "\tLEFT JOIN t_series ts on  tc.series=ts.id limit #{start},#{rows}")
    List<AppotionBean> findUserCarPage(Integer start, Integer rows);

    @Select("select count(1) from t_appointment")
    int findUserCarCount();

    @Delete("delete from t_appointment where carid = #{id}")
    void deleteAppointment(Integer id);
}
