package com.jk.serviceimpl;

import com.jk.dao.CarDao;
import com.jk.model.CarBean2;
import com.jk.pojo.AppotionBean;
import com.jk.pojo.CarBean;
import com.jk.pojo.CarBean1;
import com.jk.pojo.ImgsBean;
import com.jk.service.CarService;
import com.jk.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
@Service
public class CarServiceImpl implements CarService {


    @Autowired
    private CarDao carDao;

    /**
     *  查询汽车总表
     */
    @Override
    public HashMap<String, Object> queryCar(Integer page, Integer rows, CarBean carBean) {
        HashMap<String,Object> paramert =new HashMap<>();
        paramert.put("carBean",carBean);
        long start = (page-1)*rows;
        long total = carDao.queryCount(paramert);

        paramert.put("start",start);
        paramert.put("rows",rows);

        HashMap<String,Object> map =new HashMap<>();
        List<CarBean> list = carDao.queryCar(paramert);
        map.put("rows",list);
        map.put("total",total);
        return map;
    }

    /**
     *
     *  查询字典表的所有 类型
     */
    @Override
    public HashMap<String, Object> queryOuther() {
        HashMap<String, Object> map=new HashMap<>();

        map.put("color",carDao.queryColor());
        map.put("model",carDao.queryCarModel());
        map.put("carAge",carDao.queryCarAge());
        map.put("gearbox",carDao.queryGearbox());
        map.put("mileage",carDao.queryMileage());
        map.put("cer",carDao.queryCer());
        map.put("emissionStandard ",carDao.queryEmissionStandard());
        map.put("carSeat",carDao.queryCarSeat());
        map.put("carFuel",carDao.queryCarFuel());
        map.put("license",carDao.queryLicense());
        map.put("drive",carDao.queryDrive());
        map.put("nation",carDao.queryNation());
        map.put("configuration",carDao.queryConfiguration());
        map.put("label",carDao.queryLabel());

        return map;
    }

    /**
     *
     * @param carBean
     *  // 新增汽车表
     */
    @Override
    public Boolean addCar(CarBean carBean) {
        Boolean bool = false;
       int i = carDao.addCar(carBean);
        if(i>0){
            bool = true;
        }
        return bool;
    }

    /**
     *
     * 随机查询 12 张汽车数据
     */
    @Override
    public List<CarBean> queryCarRandom() {

        List<CarBean> carBeans = carDao.queryCarRandom();
             for (int i=0; i<carBeans.size(); i++){
                 Integer carid = carBeans.get(i).getId();
                 String imgurl= carDao.queryImgsById(carid);
                 carBeans.get(i).setImgUrl(imgurl);
             }

        return carBeans;
    }

    /**
     *
     *  根据前台Id 删除汽车表
     *
     */
    @Override
    public Boolean deleteCar(String id) {

        String[] split = id.split(",");

        Boolean bool=false;
        int i = carDao.deleteCar(split);
        if(i>0){
            bool = true;
        }
        return bool;
    }

    /**
     * 根据Id查询单条汽车表的详情
     */
    @Override
    public List<CarBean> queryCarById(Integer id) {

        List<CarBean> carBean = carDao.queryCarById(id);



        return carBean;
    }

    /**
     * 根据Id查询单条汽车图片的详情
     */
    @Override
    public List<ImgsBean> queryImgById(Integer id) {

        List<ImgsBean> imgsBeans = carDao.queryImgById(id);

        return imgsBeans;
    }

    /**
     * 修改根据Id回显
     */
    @Override
    public CarBean findCarById(Integer id) {
        return carDao.findCarById(id);
    }

    /**
     * 修改根据回显的Id
     */
    @Override
    public Boolean updateCarById(CarBean carBean) {
        Boolean bool = false;
        int i = carDao.updateCarById(carBean);
        if(i>0){
            bool = true;
        }
        return bool;
    }

    /**
     *
     * 查询Car表所有数据 缓存到ES
     */
    @Override
    public List<CarBean2> findCarListAll() {

        return carDao.findCarListAll();
    }

    /**
     * 新增图片表
     */
    @Override
    public Boolean addImgs(ImgsBean imgsBean) {
        Boolean bool = false;
        int i = carDao.addImgs(imgsBean);
        if(i>0){
            bool = true;
        }

        return bool;
    }

    /**
     * 根据汽车Id 查询图片表
     */
    @Override
    public List<ImgsBean> queryImgs(Integer id) {
        return carDao.queryImgs(id);
    }


    /**
     * 根据汽车Id 1.修改成交价格 2.并录入交易信息到mongdo数据库 3.删除本ID汽车
     * 杨恩博，只加方法，不改其他地方，我的方法 注释里都写入我的名字
     */
    @Override
    public Boolean updatePrice(CarBean carBean) {
        Boolean bool = false;
        int i = carDao.updatePrice(carBean);
        if(i>0){
            bool = true;
        }
        return bool;
    }

    /**
     * 注入MongoDB
     * 杨恩博
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 2.并录入交易信息到mongdo数据库
     * 杨恩博，只加方法，不改其他地方，我的方法 注释里都写入我的名字
     */
    @Override
    public void saveMongodb(CarBean1 carBean1) {
        mongoTemplate.insert(carBean1);
    }

    /**
     * 根据汽车Id 1.修改成交价格 2.并录入交易信息到mongdo数据库 3.删除本ID汽车
     * 杨恩博，只加方法，不改其他地方，我的方法 注释里都写入我的名字
     */
    @Override
    public void deleteCarYangEb(Integer id) {
        carDao.deleteCarYangEb(id);
    }

    /**
     * 根据汽车Id 1.修改成交价格 2.并录入交易信息到mongdo数据库 3.删除本ID汽车
     * 杨恩博，只加方法，不改其他地方，我的方法 注释里都写入我的名字
     */
    @Override
    public CarBean findCarById2(Integer id) {
        return carDao.findCarById2(id);
    }

    /**
     * 从mongo查出卖车信息
     * 杨恩博
     * @param day
     * @return
     */
    @Override
    public List<CarBean1> findSellCar(Integer day) {
        Query query = new Query();
        if(day!=null&&day>0){
            //定义时间格式
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //获取当前日期
            Date date = new Date();
            // System.out.println(date);
            //获取30天前的时间日期--minDate
            Calendar instance = Calendar.getInstance();
            instance.add(Calendar.DAY_OF_MONTH,-30);
            String format = simpleDateFormat.format(instance.getTime());
            Date parse1 = null;
            try {
                parse1 = simpleDateFormat.parse(format);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //System.out.println(format);

            query.addCriteria(Criteria.where("sellCarTime").gte(parse1));
        }

        List<CarBean1> carBean1s = mongoTemplate.find(query, CarBean1.class);
        return carBean1s;
    }

    /**
     * 用户看车记录查询
     * 杨恩博
     * @param page
     * @param rows
     * @return
     */
    @Override
    public ResultUtil findUserCar(Integer page, Integer rows) {
        ResultUtil resultUtil = new ResultUtil();
        //HashMap<String, Object> params = new HashMap<>();
        //查询总条数
        int count = carDao.findUserCarCount();
        resultUtil.setTotal(count);
        //分页查询
        Integer start = (page-1)*rows;
        List<AppotionBean> list= carDao.findUserCarPage(start,rows);
        resultUtil.setRows(list);
        return resultUtil;
    }

    @Override
    public void deleteAppointment(Integer id) {
        carDao.deleteAppointment(id);
    }


}
