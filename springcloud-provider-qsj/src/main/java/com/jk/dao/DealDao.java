package com.jk.dao;

import com.jk.pojo.AppointmentBean;
import com.jk.pojo.CarBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DealDao {



    @Select("select  * from  t_car t  where   t.id  = #{value}")
    List<CarBean> queryDealCar(Integer carid);





}
