package com.jk.dao;

import com.jk.pojo.AppointmentBean;
import org.apache.ibatis.annotations.Insert;

public interface AppointmentDao {
    @Insert("insert into t_appointment(phone,area,lookcartime,carid,status) values(#{phone},#{area},#{lookcartime},#{carid},#{status})")
    void Savexinxi(AppointmentBean appointmentBean);
}
