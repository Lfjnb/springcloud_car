package com.jk.dao;

import com.jk.pojo.StoreBean;

import java.util.List;

/**
 * 类描述：
 * 创建人：王政
 * 创建时间：2019/4/22 14:17
 * 修改人：wz
 * 修改时间：2019/4/22 14:17
 * 修改备注：
 */
public interface StoreDao {

    /**
     *
     * 查询店铺表
     */
    List<StoreBean> queryStore();
}
