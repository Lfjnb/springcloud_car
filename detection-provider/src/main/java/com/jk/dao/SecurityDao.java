package com.jk.dao;

import com.jk.pojo.SecurityBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SecurityDao {

    //根据carId查询安全配置表
    @Select("select * from t_security where carId = #{carId}")
    List<SecurityBean> querySecurity(Integer carId);

    //新增安全配置表
    @Insert("insert into t_security(airbag,sideAirbag,headAirbag,taiya,centralLock,bodyLock,noKeyStart,aBS,eSP,carId) \n" +
            "values(#{airbag},#{sideAirbag},#{headAirbag},#{taiya},#{centralLock},#{bodyLock},#{noKeyStart},#{aBS},#{eSP},#{carId})")
    void addSecurity(SecurityBean securityBean);
}
