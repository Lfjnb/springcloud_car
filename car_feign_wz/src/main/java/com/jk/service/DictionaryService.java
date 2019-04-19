package com.jk.service;

import com.jk.pojo.CarBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 类描述：
 * 创建人：王政
 * 创建时间：2019/4/18 21:13
 * 修改人：wz
 * 修改时间：2019/4/18 21:13
 * 修改备注：
 */
@FeignClient(value = "car-provider-wz")
public interface DictionaryService {


    /**
     *
     *  查询字典表
     */
    @RequestMapping("queryDictionary")
    List<CarBean> queryDictionary();

}
