package com.jk.controller;

import com.jk.pojo.CarBean;
import com.jk.service.CarService;
import com.jk.utils.IOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * 类描述：
 * 创建人：王政
 * 创建时间：2019/4/17 11:45
 * 修改人：wz
 * 修改时间：2019/4/17 11:45
 * 修改备注：
 */
@Controller
@RequestMapping("Car")
public class CarController {


    @Autowired
    private CarService carService;


    @Autowired
    private IOssService iOssService;


    /**
     *
     *  根据前台Id 删除汽车表
     *
     */
    @RequestMapping("deleteCar")
    @ResponseBody
    public Boolean deleteCar(Integer id){
        Boolean bool = carService.deleteCar(id);
        return bool;
    }


    /**
     *
     * 随机查询 12 张汽车数据
     */
    @RequestMapping("queryCarRandom")
    @ResponseBody
    public List<CarBean> queryCarRandom(){
        List<CarBean> list = carService.queryCarRandom();
        return list;
    }



    /**
     * OSS阿里云上传图片
     */
    @RequestMapping("updaloadImg")
    @ResponseBody
    public HashMap<String, Object> updaloadImg(HttpServletRequest request, HttpServletResponse response, MultipartFile img) throws IOException {
        HashMap<String, Object> result = new HashMap<>();
        String img2 = iOssService.uploadImg(img);
        result.put("path",img2);
        return result;
    }


    /**
     *
     *  新增汽车总表
     *
     */
    @RequestMapping("addCar")
    @ResponseBody
    public Boolean addCarAndImgs(CarBean carBean){
        //新增汽车表
        Boolean bool;
        bool = carService.addCar(carBean);
        return bool;
    }


    /**
     *  查询汽车总表
     */
    @RequestMapping("queryCar")
    @ResponseBody
    public HashMap<String,Object> queryCar(Integer page, Integer rows,CarBean carBean){
        HashMap<String,Object> map = carService.queryCar(page,rows,carBean);
        return map;
    }
    /**
     *  查询汽车其它配件表
     */
    @RequestMapping("queryOuther")
    @ResponseBody
    public HashMap<String,Object> queryOuther(){
        return carService.queryOuther();
    }

}
