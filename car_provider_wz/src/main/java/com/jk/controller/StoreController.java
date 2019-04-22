package com.jk.controller;

import com.jk.pojo.StoreBean;
import com.jk.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 类描述：
 * 创建人：王政
 * 创建时间：2019/4/22 14:16
 * 修改人：wz
 * 修改时间：2019/4/22 14:16
 * 修改备注：
 */
@Controller
public class StoreController {



    @Autowired
    private StoreService storeService;

    /**
     *
     * 查询店铺表
     */
    @RequestMapping("queryStore")
    @ResponseBody
    public List<StoreBean> queryStore(){
        List<StoreBean> list = storeService.queryStore();
        return list;
    }

}
