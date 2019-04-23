package com.jk.dao;

import com.jk.pojo.ExternalBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ExternalDao {

    //根据carId查询外部配置表
    @Select("select * from t_external where carId = #{carId}")
    List<ExternalBean> queryExternal(Integer carId);

    //新增外部配置表
    @Insert("insert into t_external(powerSunroof,allSunroof,powerDoor,ganyingBox,ganyiBrush,houBrush,allPowerSunroof,powerHouMirror,houMirrorHot,carId)\n" +
            "values(#{powerSunroof},#{allSunroof},#{powerDoor},#{ganyingBox},#{ganyiBrush},#{houBrush},#{allPowerSunroof},#{powerHouMirror},#{houMirrorHot},#{carId})")
    void addExternal(ExternalBean externalBean);
}
