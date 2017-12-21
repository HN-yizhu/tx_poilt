package com.poilt.pojo;

import java.util.Date;

public class SysLog {
    private Integer id;

    private Integer userId;

    private String userName;

    private String option;

    private String reqParam;

    private String respResult;

    private Date createTim;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option == null ? null : option.trim();
    }

    public String getReqParam() {
        return reqParam;
    }

    public void setReqParam(String reqParam) {
        this.reqParam = reqParam == null ? null : reqParam.trim();
    }

    public String getRespResult() {
        return respResult;
    }

    public void setRespResult(String respResult) {
        this.respResult = respResult == null ? null : respResult.trim();
    }

    public Date getCreateTim() {
        return createTim;
    }

    public void setCreateTim(Date createTim) {
        this.createTim = createTim;
    }
}