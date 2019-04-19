package com.jk.dao;


import com.jk.pojo.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface ShiroDao {

    @Select("select  *  from  t_user  where  phone=#{value}")
    UserBean findIntoByAccount(String userName);

    @Insert("insert into  t_user(phone,password) values(#{phone},#{password})")
    void addUser(UserBean userBean);
}
