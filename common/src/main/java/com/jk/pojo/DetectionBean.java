package com.jk.pojo;

import java.io.Serializable;

/**
 * 检测表
 */
public class DetectionBean implements Serializable {

    private static final long serialVersionUID = -462235526439374233L;
    private Integer id;

    private String detectionName;//检测名称

    private Integer pid;

    private Integer status;

    private Integer count;

    public Integer getCount() {
        return count;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetectionName() {
        return detectionName;
    }

    public void setDetectionName(String detectionName) {
        this.detectionName = detectionName;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
