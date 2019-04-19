package com.jk.dao;

import com.jk.pojo.CarBean;

import java.util.List;

/**
 * 类描述：
 * 创建人：王政
 * 创建时间：2019/4/18 21:03
 * 修改人：wz
 * 修改时间：2019/4/18 21:03
 * 修改备注：
 */
public interface DictionaryDao {
    /**
     *
     *  查询字典表
     */
    List<CarBean> queryDictionary();
}
