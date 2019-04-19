package com.jk.serviceimpl;

import com.jk.dao.CarDao;
import com.jk.pojo.CarBean;
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

    @Override
    public HashMap<String, Object> queryOuther() {
        HashMap<String, Object> map=new HashMap<>();
            map.put("color",carDao.queryColor());
            map.put("model",carDao.queryCarModel());
            map.put("carAge",carDao.queryCarAge());
            map.put("gearbox",carDao.queryGearbox());
            map.put("mileage",carDao.queryMileage());
            map.put("carSeat",carDao.queryCarSeat());
            map.put("carFuel",carDao.queryCarFuel());
            map.put("license",carDao.queryLicense());
            map.put("drive",carDao.queryDrive());
            map.put("nation",carDao.queryNation());

        return map;
    }

}