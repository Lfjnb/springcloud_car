package com.jk.controller;

import com.jk.pojo.CarBean;
import com.jk.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 类描述：
 * 创建人：王政
 * 创建时间：2019/4/18 21:12
 * 修改人：wz
 * 修改时间：2019/4/18 21:12
 * 修改备注：
 */
@Controller
@RequestMapping("Dictionary")
public class DictionaryController {


    @Autowired
    private DictionaryService dictionaryService;


    /**
     *
     *  查询字典表
     */
    @RequestMapping("queryDictionary")
    @ResponseBody
    public List<CarBean> queryDictionary(){
        List<CarBean> list = dictionaryService.queryDictionary();
        return list;
    }

}
