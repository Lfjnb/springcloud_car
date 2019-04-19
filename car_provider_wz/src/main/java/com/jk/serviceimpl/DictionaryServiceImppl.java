package com.jk.serviceimpl;

import com.jk.dao.DictionaryDao;
import com.jk.pojo.CarBean;
import com.jk.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述：
 * 创建人：王政
 * 创建时间：2019/4/18 21:00
 * 修改人：wz
 * 修改时间：2019/4/18 21:00
 * 修改备注：
 */
@Service
public class DictionaryServiceImppl implements DictionaryService {

    @Autowired
    private DictionaryDao dictionaryDao;

    /**
     *
     *  查询字典表
     */
    @Override
    public List<CarBean> queryDictionary() {
        return dictionaryDao.queryDictionary();
    }
}
