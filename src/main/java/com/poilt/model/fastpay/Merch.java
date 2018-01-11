package com.poilt.model.fastpay;

import java.util.Date;

public class Merch {
    private Integer id;

    private String merName;

    private String merAbbr;

    private String idCardNo;

    private String openId;

    private String creditRate;

    private Integer historyTotal;

    private Integer creditFee;

    private String referrer;

    private Date createTime;

    private String merUuid;

    private String merNo;

    private String attenState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMerName() {
        return merName;
    }

    public void setMerName(String merName) {
        this.merName = merName == null ? null : merName.trim();
    }

    public String getMerAbbr() {
        return merAbbr;
    }

    public void setMerAbbr(String merAbbr) {
        this.merAbbr = merAbbr == null ? null : merAbbr.trim();
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo == null ? null : idCardNo.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getCreditRate() {
        return creditRate;
    }

    public void setCreditRate(String creditRate) {
        this.creditRate = creditRate == null ? null : creditRate.trim();
    }

    public Integer getHistoryTotal() {
        return historyTotal;
    }

    public void setHistoryTotal(Integer historyTotal) {
        this.historyTotal = historyTotal;
    }

    public Integer getCreditFee() {
        return creditFee;
    }

    public void setCreditFee(Integer creditFee) {
        this.creditFee = creditFee;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer == null ? null : referrer.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMerUuid() {
        return merUuid;
    }

    public void setMerUuid(String merUuid) {
        this.merUuid = merUuid == null ? null : merUuid.trim();
    }

    public String getMerNo() {
        return merNo;
    }

    public void setMerNo(String merNo) {
        this.merNo = merNo == null ? null : merNo.trim();
    }

    public String getAttenState() {
        return attenState;
    }

    public void setAttenState(String attenState) {
        this.attenState = attenState == null ? null : attenState.trim();
    }
}