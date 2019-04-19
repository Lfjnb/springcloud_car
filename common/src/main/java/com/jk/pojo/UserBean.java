package com.jk.pojo;

import java.io.Serializable;

/**
 * 类描述：用户表
 * 创建人：孙长江
 * 创建时间：2019/4/1619:24
 * 修改人：孙长江
 * 修改时间：2019/4/1619:24
 * 修改备注：
 */
public class UserBean implements Serializable {

    private static final long serialVersionUID = 8812395333261873783L;
    private Integer id;

    private String phone;//手机号

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
