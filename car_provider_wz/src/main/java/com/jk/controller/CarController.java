package com.jk.controller;

import com.jk.model.CarBean2;
import com.jk.pojo.CarBean;
import com.jk.pojo.CarBean1;
import com.jk.pojo.ImgsBean;
import com.jk.service.CarService;
import com.jk.utils.ResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 类描述：
 * 创建人：王政
 * 创建时间：2019/4/18 14:03
 * 修改人：wz
 * 修改时间：2019/4/18 14:03
 * 修改备注：
 */
@Controller
public class CarController {


    @Autowired
    private CarService carService;


    @Autowired
    private RedisTemplate redisTemplate;




    /**
     * 根据汽车Id 查询图片表
     */
    @RequestMapping("queryImgs/{id}")
    @ResponseBody
    public List<ImgsBean> queryImgs(@PathVariable Integer id){
        List<ImgsBean> list = carService.queryImgs(id);
        return list;
    }





    /**
     * 新增图片表
     */
    @RequestMapping("addImgs")
    @ResponseBody
    public Boolean addImgs(@RequestBody ImgsBean imgsBean){
        Boolean bool = carService.addImgs(imgsBean);
        return bool;
    }



    /**
     *
     * 查询Car表所有数据 缓存到ES
     */
    @RequestMapping("findCarListAll")
    @ResponseBody
    public List<CarBean2> findCarListAll(){
        List<CarBean2> list = carService.findCarListAll();
        return list;
    }




    /**
     * 修改根据回显的Id
     */
    @RequestMapping("updateCarById")
    @ResponseBody
    public Boolean updateCarById(@RequestBody CarBean carBean){
        Boolean bool = carService.updateCarById(carBean);
        return bool;
    }



    /**
     * 修改根据Id回显
     */
    @ResponseBody
    @RequestMapping("findCarById/{id}")
    CarBean findCarById(@PathVariable Integer id){
        return carService.findCarById(id);
    }



    /**
     * 根据Id查询单条汽车表的详情
     */
    @RequestMapping("queryCarById/{id}")
    @ResponseBody
    public HashMap<String,Object> queryCarById(@PathVariable Integer id){

        HashMap<String,Object> map = new HashMap<>();

        List<CarBean> carBean = carService.queryCarById(id);

        List<ImgsBean> imgsBeans = carService.queryImgById(id);

        map.put("carBean",carBean);
        map.put("imgs",imgsBeans);


        return map;
    }




    /**
     *
     *  根据前台Id 删除汽车表
     *
     */
    @RequestMapping("deleteCar/{id}")
    @ResponseBody
    public Boolean deleteCar(@PathVariable String id){
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
     * 根据汽车Id 1.修改成交价格 2.并录入交易信息到mongdo数据库 3.删除本ID汽车
     * 杨恩博，只加方法，不改其他地方，我的方法 注释里都写入我的名字
     */
    @RequestMapping("updatePrice")
    @ResponseBody
    public Boolean updatePrice(@RequestBody CarBean carBean) {
        Boolean bool = carService.updatePrice(carBean);//修改成交价格 注意：可不从数据库查询price(修改的目的就是修改这个成交价格)，直接set到拷贝后的carBean1里面
        CarBean carById = carService.findCarById2(carBean.getId());//根据汽车Id 查询修改过价格的车的信息（卖出的车）
        CarBean1 carBean1 = new CarBean1();
        BeanUtils.copyProperties(carById,carBean1);
        carBean1.setSellCarTime(new Date());
        carService.saveMongodb(carBean1); //存入mongo
        carService.deleteCarYangEb(carBean.getId()); //你的删除Id为String carBean.gitId 为Integer 报错  我重新写个
        carService.deleteAppointment(carBean.getId());
        return bool;
    }

    /**
     * 从mongo查出卖车信息
     * @return
     */
    @RequestMapping("findSellCar/{day}")
    @ResponseBody
    public List<CarBean1> findSellCar(@PathVariable Integer day){

        return carService.findSellCar(day);
    }
    /**
     * 用户看车记录查询
     * 杨恩博
     * @param page
     * @param rows
     * @return
     */
    @ResponseBody
    @RequestMapping("findUserCar")
    public ResultUtil findUserCar(@RequestParam Integer page, @RequestParam Integer rows){
        return carService.findUserCar(page,rows);
    }



    /**
     *
     *  新增汽车总表
     *
     */
    @RequestMapping("addCar")
    @ResponseBody
    public Boolean addCar(@RequestBody CarBean carBean){
        Boolean bool;
        //新增汽车表
     bool = carService.addCar(carBean);
     return bool;


}




    /**
     *  查询汽车总表
     */
    @ResponseBody
    @RequestMapping("queryCar")
    public HashMap<String,Object> queryCar(@RequestParam Integer page, @RequestParam Integer rows,@RequestBody CarBean carBean){
        HashMap<String,Object> map = carService.queryCar(page,rows,carBean);
        return map;
    }

    /**
     *
     *  查询字典表的所有 类型
     */
    @RequestMapping("queryOuther")
    @ResponseBody
    public HashMap<String,Object> queryOuther() {

        HashMap<String, Object> mapObject = (HashMap<String, Object>) redisTemplate.opsForValue().get("queryOuther" + 1);

        try {
            if (mapObject == null) {
                HashMap<String, Object> map = carService.queryOuther();
                redisTemplate.opsForValue().set("queryOuther" + 1, map);
                return map;
            }
            return mapObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
