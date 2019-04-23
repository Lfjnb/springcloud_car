package com.jk.controller;

import com.jk.model.CarBean2;
import com.jk.pojo.CarBean;
import com.jk.pojo.ImgsBean;
import com.jk.repostory.CarRepostory;
import com.jk.service.CarService;
import com.jk.utils.IOssService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

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

    @Autowired
    private CarRepostory carRepostory;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    /**
     *
     * 查询Car表所有数据 缓存到ES
     */
    @Scheduled(fixedRate = 5000)//定时器注解
    @ResponseBody
    public void testTasks(){
        List<CarBean2> list = carService.findCarListAll();
        System.out.println("定时器");
        for (CarBean2 carBean2:list){
            carRepostory.save(carBean2);
        }
    }






    /**
     *
     *
     * @param carNames
     * @param page
     * @param rows
     * @ 通过ES 全局搜索
     */
    @RequestMapping("findCarList")
    @ResponseBody
    public List<CarBean2> findBookList(String carNames, Integer page, Integer rows) {
        List<CarBean2> carList = new ArrayList<>();
        Client client = elasticsearchTemplate.getClient();
        SearchRequestBuilder searchRequestBuilder = null;

        //查询具体索引
        searchRequestBuilder = client.prepareSearch("1809a")
                //查询具体的类型 参数为类型名称 可以传多个
                .setTypes("car");
        //分页用
        searchRequestBuilder.setQuery(QueryBuilders.matchAllQuery());
        searchRequestBuilder.setFrom((page - 1) * rows).setSize(rows);
        //条件
        searchRequestBuilder = client.prepareSearch("1809a")
                .setTypes("car")
                .setQuery(new QueryStringQueryBuilder(carNames));


        //得到查询结果
        SearchResponse searchResponse = searchRequestBuilder.get();

        SearchHits hits = searchResponse.getHits();
        //迭代器
        Iterator<SearchHit> iterator = hits.iterator();
/*
        HashMap<String, Object> map = new HashMap<>();
*/
        while (iterator.hasNext()) {
            CarBean2 carBean21 = new CarBean2();
            SearchHit next = iterator.next();
            Map<String, Object> sourceAsMap = next.getSourceAsMap();
            /*添加id*/
            Integer id = (Integer) sourceAsMap.get("id");
            carBean21.setId(id);
            /*颜色*/
            String name = (String) sourceAsMap.get("colorName");
            carBean21.setColorName(name);
            /*汽车名称*/
            String carName = (String) sourceAsMap.get("carName");
            carBean21.setCarName(carName);

            Integer mileageId = (Integer) sourceAsMap.get("mileageId");
            carBean21.setMileageId(mileageId);

            Integer carSeat = (Integer) sourceAsMap.get("carSeat");
            carBean21.setCarSeat(carSeat);

            String carModelName = (String)sourceAsMap.get("carModelName");
            carBean21.setCarModelName(carModelName);

            String carSeatName = (String)sourceAsMap.get("carSeatName");
            carBean21.setCarSeatName(carSeatName);

            Integer ownerId = (Integer) sourceAsMap.get("ownerId");
            carBean21.setOwnerId(ownerId);

            String elseName = (String)sourceAsMap.get("elseName");
            carBean21.setElseName(elseName);

            String carLicense = (String)sourceAsMap.get("carLicense");
            carBean21.setCarLicense(carLicense);

            String ownerName = (String)sourceAsMap.get("ownerName");
            carBean21.setOwnerName(ownerName);

            String areaName = (String)sourceAsMap.get("areaName");
            carBean21.setAreaName(areaName);

            Double price= (Double) sourceAsMap.get("price");
            carBean21.setPrice(price);

            String storeName = (String)sourceAsMap.get("storeName");
            carBean21.setStoreName(storeName);

            Integer carAgeId = (Integer) sourceAsMap.get("carAgeId");
            carBean21.setCarAgeId(carAgeId);

            Integer gearbox = (Integer)sourceAsMap.get("gearbox");
            carBean21.setGearbox(gearbox);

            String mileageName = (String)sourceAsMap.get("mileageName");
            carBean21.setMileageName(mileageName);

            Integer carFuel = (Integer)sourceAsMap.get("carFuel");
            carBean21.setCarFuel(carFuel);

            Double startPrice= (Double) sourceAsMap.get("startPrice");
            carBean21.setStartPrice(startPrice);

            String brandName = (String)sourceAsMap.get("brandName");
            carBean21.setBrandName(brandName);

            String nationName = (String)sourceAsMap.get("nationName");
            carBean21.setNationName(nationName);

            String seriesName = (String)sourceAsMap.get("seriesName");
            carBean21.setSeriesName(seriesName);

            Integer start = (Integer)sourceAsMap.get("start");
            carBean21.setStart(start);

            Integer nationId = (Integer)sourceAsMap.get("nationId");
            carBean21.setNationId(nationId);

            Double endPrice= (Double) sourceAsMap.get("endPrice");
            carBean21.setEndPrice(endPrice);

            Integer storeId = (Integer)sourceAsMap.get("storeId");
            carBean21.setStoreId(storeId);

            Integer carCerId = (Integer)sourceAsMap.get("carCerId");
            carBean21.setCarCerId(carCerId);

            String carFuelName = (String)sourceAsMap.get("carFuelName");
            carBean21.setCarFuelName(carFuelName);

            String imgUrl = (String)sourceAsMap.get("imgUrl");
            carBean21.setImgUrl(imgUrl);

            String carAgeName = (String)sourceAsMap.get("carAgeName");
            carBean21.setCarAgeName(carAgeName);

            Integer license = (Integer)sourceAsMap.get("license");
            carBean21.setLicense(license);

            Integer areaId = (Integer)sourceAsMap.get("areaId");
            carBean21.setAreaId(areaId);

            Integer elseId = (Integer)sourceAsMap.get("elseId");
            carBean21.setElseId(elseId);

            Integer series = (Integer)sourceAsMap.get("series");
            carBean21.setSeries(series);

            Integer brandId = (Integer)sourceAsMap.get("brandId");
            carBean21.setBrandId(brandId);

            Integer drive = (Integer)sourceAsMap.get("drive");
            carBean21.setDrive(drive);

            String carCerNmae = (String)sourceAsMap.get("carCerNmae");
            carBean21.setCarCerNmae(carCerNmae);

            Integer carModel = (Integer)sourceAsMap.get("carModel");
            carBean21.setCarModel(carModel);

            carList.add(carBean21);
        }
        return carList;
    }




    /**
     * 修改根据回显的Id
     */
    @RequestMapping("updateCarById")
    @ResponseBody
    public Boolean updateCarById(CarBean carBean){
        Boolean bool = carService.updateCarById(carBean);
        return bool;
    }



    /**
     * 修改根据Id回显
     */
    @RequestMapping("findCarById")
    @ResponseBody
    public CarBean findCarById(Integer id){

        return carService.findCarById(id);
    }


    /**
     * 根据Id查询单条汽车表的详情
     */
    @RequestMapping("queryCarById")
    @ResponseBody
    public HashMap<String,Object> queryCarById(Integer id){
        HashMap<String,Object> map = carService.queryCarById(id);
        return map;
    }




    @Autowired
    private CarRepostory carRepostory;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    /**
     *
     * 查询Car表所有数据 缓存到ES
     */
    @Scheduled(fixedRate = 5000)//定时器注解
    @ResponseBody
    public void testTasks(){
        List<CarBean2> list = carService.findCarListAll();
        System.out.println("定时器");
        for (CarBean2 carBean2:list){
            carRepostory.save(carBean2);
        }
    }






    /**
     *
     * @ 通过ES 全局搜索
     */
    @RequestMapping("queryCares")
    @ResponseBody
    public List<CarBean2> findBookList(String carNames, Integer page, Integer rows) {
        page=1;
        rows=12;
        List<CarBean2> carList = new ArrayList<>();
        Client client = elasticsearchTemplate.getClient();
        SearchRequestBuilder searchRequestBuilder = null;

        //查询具体索引
        searchRequestBuilder = client.prepareSearch("1809a")
                //查询具体的类型 参数为类型名称 可以传多个
                .setTypes("car");
        //分页用
        searchRequestBuilder.setQuery(QueryBuilders.matchAllQuery());
        searchRequestBuilder.setFrom((page - 1) * rows).setSize(rows);
        //条件
        if (carNames!=null &&  !carNames.equals("")) {
            searchRequestBuilder = client.prepareSearch("1809a")
                    .setTypes("car")
                    .setQuery(new QueryStringQueryBuilder(carNames));
        }
//        if (carBean.getCarAgeName()!=null && !carBean.getCarAgeName().equals("-1")){
//            searchRequestBuilder=client.prepareSearch("1809a")
//                    .setTypes("car")
//                    .setQuery(QueryBuilders.matchQuery("carAgeName",carBean.getCarAgeName()));
//        }
//        if (carBean.getCarModelName()!=null && !carBean.getCarModelName().equals("-1")){
//            searchRequestBuilder=client.prepareSearch("1809a")
//                    .setTypes("car")
//                    .setQuery(QueryBuilders.matchQuery("carModelName",carBean.getCarModelName()));
//        }


        //得到查询结果
        SearchResponse searchResponse = searchRequestBuilder.get();

        SearchHits hits = searchResponse.getHits();
        //迭代器
        Iterator<SearchHit> iterator = hits.iterator();
/*
        HashMap<String, Object> map = new HashMap<>();
*/
        while (iterator.hasNext()) {
            CarBean2 carBean21 = new CarBean2();
            SearchHit next = iterator.next();
            Map<String, Object> sourceAsMap = next.getSourceAsMap();
            /*添加id*/
            Integer id = (Integer) sourceAsMap.get("id");
            carBean21.setId(id);
            /*颜色*/
            String name = (String) sourceAsMap.get("colorName");
            carBean21.setColorName(name);
            /*汽车名称*/
            String carName = (String) sourceAsMap.get("carName");
            carBean21.setCarName(carName);

            Integer mileageId = (Integer) sourceAsMap.get("mileageId");
            carBean21.setMileageId(mileageId);

            Integer carSeat = (Integer) sourceAsMap.get("carSeat");
            carBean21.setCarSeat(carSeat);

            String carModelName = (String)sourceAsMap.get("carModelName");
            carBean21.setCarModelName(carModelName);

            String carSeatName = (String)sourceAsMap.get("carSeatName");
            carBean21.setCarSeatName(carSeatName);

            Integer ownerId = (Integer) sourceAsMap.get("ownerId");
            carBean21.setOwnerId(ownerId);

            String elseName = (String)sourceAsMap.get("elseName");
            carBean21.setElseName(elseName);

            String carLicense = (String)sourceAsMap.get("carLicense");
            carBean21.setCarLicense(carLicense);

            String ownerName = (String)sourceAsMap.get("ownerName");
            carBean21.setOwnerName(ownerName);

            String areaName = (String)sourceAsMap.get("areaName");
            carBean21.setAreaName(areaName);

            Double price= (Double) sourceAsMap.get("price");
            carBean21.setPrice(price);

            String storeName = (String)sourceAsMap.get("storeName");
            carBean21.setStoreName(storeName);

            Integer carAgeId = (Integer) sourceAsMap.get("carAgeId");
            carBean21.setCarAgeId(carAgeId);

            Integer gearbox = (Integer)sourceAsMap.get("gearbox");
            carBean21.setGearbox(gearbox);

            String mileageName = (String)sourceAsMap.get("mileageName");
            carBean21.setMileageName(mileageName);

            Integer carFuel = (Integer)sourceAsMap.get("carFuel");
            carBean21.setCarFuel(carFuel);

            Double startPrice= (Double) sourceAsMap.get("startPrice");
            carBean21.setStartPrice(startPrice);

            String brandName = (String)sourceAsMap.get("brandName");
            carBean21.setBrandName(brandName);

            String nationName = (String)sourceAsMap.get("nationName");
            carBean21.setNationName(nationName);

            String seriesName = (String)sourceAsMap.get("seriesName");
            carBean21.setSeriesName(seriesName);

            Integer start = (Integer)sourceAsMap.get("start");
            carBean21.setStart(start);

            Integer nationId = (Integer)sourceAsMap.get("nationId");
            carBean21.setNationId(nationId);

            Double endPrice= (Double) sourceAsMap.get("endPrice");
            carBean21.setEndPrice(endPrice);

            Integer storeId = (Integer)sourceAsMap.get("storeId");
            carBean21.setStoreId(storeId);

            Integer carCerId = (Integer)sourceAsMap.get("carCerId");
            carBean21.setCarCerId(carCerId);

            String carFuelName = (String)sourceAsMap.get("carFuelName");
            carBean21.setCarFuelName(carFuelName);

            String imgUrl = (String)sourceAsMap.get("imgUrl");
            carBean21.setImgUrl(imgUrl);

            String carAgeName = (String)sourceAsMap.get("carAgeName");
            carBean21.setCarAgeName(carAgeName);

            Integer license = (Integer)sourceAsMap.get("license");
            carBean21.setLicense(license);

            Integer areaId = (Integer)sourceAsMap.get("areaId");
            carBean21.setAreaId(areaId);

            Integer elseId = (Integer)sourceAsMap.get("elseId");
            carBean21.setElseId(elseId);

            Integer series = (Integer)sourceAsMap.get("series");
            carBean21.setSeries(series);

            Integer brandId = (Integer)sourceAsMap.get("brandId");
            carBean21.setBrandId(brandId);

            Integer drive = (Integer)sourceAsMap.get("drive");
            carBean21.setDrive(drive);

            String carCerNmae = (String)sourceAsMap.get("carCerNmae");
            carBean21.setCarCerNmae(carCerNmae);

            Integer carModel = (Integer)sourceAsMap.get("carModel");
            carBean21.setCarModel(carModel);

            carList.add(carBean21);
        }
        return carList;
    }




    /**
     * 修改根据回显的Id
     */
    @RequestMapping("updateCarById")
    @ResponseBody
    public Boolean updateCarById(CarBean carBean){
        Boolean bool = carService.updateCarById(carBean);
        return bool;
    }



    /**
     * 修改根据Id回显
     */
    @RequestMapping("findCarById")
    @ResponseBody
    public CarBean findCarById(Integer id){

        return carService.findCarById(id);
    }


    /**
     * 根据Id查询单条汽车表的详情
     */
    @RequestMapping("queryCarById")
    @ResponseBody
    public HashMap<String,Object> queryCarById(Integer id){
        HashMap<String,Object> map = carService.queryCarById(id);
        return map;
    }





    /**
     *
     *  根据前台Id 删除汽车表
     *
     */
    @RequestMapping("deleteCar")
    @ResponseBody
    public Boolean deleteCar(String id){
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
     * 新增图片表
     */
    @RequestMapping("addImgs")
    @ResponseBody
    public Boolean addImgs(ImgsBean imgsBean){
        Boolean bool = carService.addImgs(imgsBean);
        return bool;
    }


    /**
     * 根据汽车Id 查询图片表
     */
    @RequestMapping("queryImgs")
    @ResponseBody
    public List<ImgsBean> queryImgs(Integer id){
        List<ImgsBean> list = carService.queryImgs(id);
        return list;
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
         page = 1;
         rows = 10;
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
