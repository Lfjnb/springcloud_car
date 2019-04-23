package com.jk.pojo;

import java.io.Serializable;

/**
 * 安全配置
 */
public class SecurityBean implements Serializable {

    private static final long serialVersionUID = 2868451890257576196L;
    private Integer id;

    private Integer airbag;//主副驾驶安全气囊 1:正常/正常 2：正常/无

    private Integer sideAirbag;//前后排侧气囊 1:正常/正常 2：正常/无 3：无/无

    private Integer headAirbag;//前后排头部气囊 1:正常/正常 2：正常/无 3：无/无

    private Integer taiya;//胎压检测 1：标配 2：无

    private Integer centralLock;//车内中控锁 1：标配  2：无

    private Integer bodyLock;//儿童座椅接口 1：标配  2：无

    private Integer noKeyStart;//无钥匙启动 1：有  2：无

    private Integer aBS;//防抱死系统(ABS) 1：标配  2：无

    private Integer eSP;//车身稳定控制(ESP) 1：标配  2：无

    private Integer carId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAirbag() {
        return airbag;
    }

    public void setAirbag(Integer airbag) {
        this.airbag = airbag;
    }

    public Integer getSideAirbag() {
        return sideAirbag;
    }

    public void setSideAirbag(Integer sideAirbag) {
        this.sideAirbag = sideAirbag;
    }

    public Integer getHeadAirbag() {
        return headAirbag;
    }

    public void setHeadAirbag(Integer headAirbag) {
        this.headAirbag = headAirbag;
    }

    public Integer getTaiya() {
        return taiya;
    }

    public void setTaiya(Integer taiya) {
        this.taiya = taiya;
    }

    public Integer getCentralLock() {
        return centralLock;
    }

    public void setCentralLock(Integer centralLock) {
        this.centralLock = centralLock;
    }

    public Integer getBodyLock() {
        return bodyLock;
    }

    public void setBodyLock(Integer bodyLock) {
        this.bodyLock = bodyLock;
    }

    public Integer getNoKeyStart() {
        return noKeyStart;
    }

    public void setNoKeyStart(Integer noKeyStart) {
        this.noKeyStart = noKeyStart;
    }

    public Integer getaBS() {
        return aBS;
    }

    public void setaBS(Integer aBS) {
        this.aBS = aBS;
    }

    public Integer geteSP() {
        return eSP;
    }

    public void seteSP(Integer eSP) {
        this.eSP = eSP;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
}
