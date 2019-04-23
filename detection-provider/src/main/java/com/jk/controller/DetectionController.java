package com.jk.controller;

import com.jk.dao.DetectionDao;
import com.jk.pojo.CarDetectionBean;
import com.jk.pojo.DetectionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class DetectionController {

    @Autowired
    private DetectionDao detectionDao;

    //根据汽车Id跟检测项Pid查询出每项检测异常
    //通过汽车异常中间表跟检测表对比
    @RequestMapping("queryDetectionStatus")
    @ResponseBody
    public List<DetectionBean> queryDetectionStatus(@RequestParam Integer carId,@RequestParam Integer pid){
        List<CarDetectionBean> detectionCars = detectionDao.queryDetectionCarByCarId(carId);
        List<DetectionBean> detectionBeans = detectionDao.queryDetectionByPid(pid);
        for (int i = 0; i<detectionCars.size() ; i++){
            for (int j = 0; j<detectionBeans.size() ; j++){
                Integer detectionId = detectionCars.get(i).getDetectionId();
                Integer id = detectionBeans.get(j).getId();
                if(id == detectionId){
                    detectionBeans.get(j).setStatus(1);
                }
            }
        }
        return detectionBeans;
    }

    //根据汽车Id跟检测项Pid查询出每项检测异常数量
    @RequestMapping("queryDetectionCount")
    @ResponseBody
    public HashMap<String , Object> queryDetectionCount(@RequestParam Integer carId,@RequestParam Integer pid){
        HashMap<String, Object> params = new HashMap<>();
        int count = detectionDao.queryDetectionCount(carId, pid);
        params.put("count",count);
        return params;
    }

    //新增异常检测
    @RequestMapping("addCarDetection")
    @ResponseBody
    public Boolean addCarDetection(@RequestBody CarDetectionBean carDetectionBean){
        try{
            detectionDao.addCarDetection(carDetectionBean);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //查询出除最上一级其他检测项
    @RequestMapping("queryDetection")
    @ResponseBody
    public List<DetectionBean> queryDetection(){
        return detectionDao.queryDetection();
    }

    //查询所有异常根据carId
    @RequestMapping("queryCarDetection")
    @ResponseBody
    public List<DetectionBean> queryCarDetection(@RequestParam Integer carId){
        return detectionDao.queryCarDetection(carId);
    }



}
