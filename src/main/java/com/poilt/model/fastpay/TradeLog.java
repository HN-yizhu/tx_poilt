package com.poilt.model.fastpay;

import java.util.Date;

public class TradeLog {
    private Integer id;

    private String tradeNo;

    private Integer tradeAmt;

    private String userName;

    private String userCertNo;

    private String payCardNo;

    private Date tradeTime;

    private String status;

    private String traceNo;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public Integer getTradeAmt() {
        return tradeAmt;
    }

    public void setTradeAmt(Integer tradeAmt) {
        this.tradeAmt = tradeAmt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserCertNo() {
        return userCertNo;
    }

    public void setUserCertNo(String userCertNo) {
        this.userCertNo = userCertNo == null ? null : userCertNo.trim();
    }

    public String getPayCardNo() {
        return payCardNo;
    }

    public void setPayCardNo(String payCardNo) {
        this.payCardNo = payCardNo == null ? null : payCardNo.trim();
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo == null ? null : traceNo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}