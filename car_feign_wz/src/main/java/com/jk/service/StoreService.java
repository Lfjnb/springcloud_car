package com.jk.service;

import com.jk.pojo.StoreBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 类描述：
 * 创建人：王政
 * 创建时间：2019/4/22 14:11
 * 修改人：wz
 * 修改时间：2019/4/22 14:11
 * 修改备注：
 */
@FeignClient(value = "car-provider-wz")
public interface StoreService {
    /**
     *
     * 查询店铺表
     */
    @RequestMapping("queryStore")
    List<StoreBean> queryStore();
}
