package com.jk.dao;


import com.jk.pojo.AppointmentBean;
import org.apache.ibatis.annotations.Select;

public interface LoginDao {



    void add(Long phone);

    @Select("SELECT * FROM t_appointment t where  t.carid=#{carid}  and  t.phone=#{toString}")
    AppointmentBean selectLoginUser(Integer carid, String toString);
}
