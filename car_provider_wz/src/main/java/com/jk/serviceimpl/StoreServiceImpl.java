package com.jk.serviceimpl;

import com.jk.dao.StoreDao;
import com.jk.pojo.StoreBean;
import com.jk.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述：
 * 创建人：王政
 * 创建时间：2019/4/22 14:16
 * 修改人：wz
 * 修改时间：2019/4/22 14:16
 * 修改备注：
 */
@Service
public class StoreServiceImpl implements StoreService {



    @Autowired
    private StoreDao storeDao;

    /**
     *
     * 查询店铺表
     */
    @Override
    public List<StoreBean> queryStore() {
        return storeDao.queryStore();
    }
}
