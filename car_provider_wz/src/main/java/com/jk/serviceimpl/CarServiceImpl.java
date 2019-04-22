package com.jk.serviceimpl;

import com.jk.dao.CarDao;
import com.jk.model.CarBean2;
import com.jk.pojo.CarBean;
import com.jk.pojo.ImgsBean;
import com.jk.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
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
@Service
public class CarServiceImpl implements CarService {


    @Autowired
    private CarDao carDao;

    /**
     *  查询汽车总表
     */
    @Override
    public HashMap<String, Object> queryCar(Integer page, Integer rows, CarBean carBean) {
        long start = (page-1)*rows;
        long total = carDao.queryCount(carBean);

        HashMap<String,Object> map =new HashMap<>();
        List<CarBean> list = carDao.queryCar(start,rows,carBean);
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


}
