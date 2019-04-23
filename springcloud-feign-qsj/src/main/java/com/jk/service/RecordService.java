package com.jk.service;

import com.jk.pojo.CarBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient("springcloud-car-reg")
public interface RecordService {




    @RequestMapping("record/saveRecord")
    @ResponseBody
    List<CarBean> saveRecord(@RequestParam Integer carid,@RequestParam String  phonee);

    @RequestMapping("record/queryRecord")
    @ResponseBody
    List<CarBean> queryRecord(@RequestParam String phonee);
}
