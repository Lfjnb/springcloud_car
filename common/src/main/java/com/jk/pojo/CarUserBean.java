package com.jk.pojo;

import java.io.Serializable;

/**
 * 类描述：前段用户登录表
 * 创建人：孙长江
 * 创建时间：2019/4/1922:13
 * 修改人：孙长江
 * 修改时间：2019/4/1922:13
 * 修改备注：
 */
public class CarUserBean implements Serializable {

    private static final long serialVersionUID = -3990253965828562196L;
    private Integer id;//用户id

    private Long phone; //手机号

    private Integer carId; //收藏汽车id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
}
