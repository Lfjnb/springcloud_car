package com.jk.dao;

import com.jk.pojo.CarBean;
import com.jk.pojo.SellcarBean;

import java.util.HashMap;
import java.util.List;

public interface SellCarDao {
    void addSellCar(SellcarBean sellcarBean);

    int findCount(HashMap<String, Object> map);


    List<SellcarBean> findlist(HashMap<String, Object> map);
}
