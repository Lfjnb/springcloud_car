package com.jk.service;

import com.jk.pojo.StoreBean;

import java.util.List;

/**
 * 类描述：
 * 创建人：王政
 * 创建时间：2019/4/22 14:16
 * 修改人：wz
 * 修改时间：2019/4/22 14:16
 * 修改备注：
 */
public interface StoreService {
    /**
     *
     * 查询店铺表
     */
    List<StoreBean> queryStore();
}
