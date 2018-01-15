package com.poilt.model.fastpay;

import java.util.Date;

public class Merch {
	private Integer id;

	private String openId;

	private String merName;

	private String name;

	private String phone;

	private String idCard;

	private Double creditRate;

	private Double creditFee;

	private Double historyTotal;

	private String referrer;

	private String attenState;

	private String tiedCard;
	
	private String merchUuid;
	
	private String merNo;

	public String getMerchUuid() {
		return merchUuid;
	}

	public void setMerchUuid(String merchUuid) {
		this.merchUuid = merchUuid;
	}

	public String getMerNo() {
		return merNo;
	}

	public void setMerNo(String merNo) {
		this.merNo = merNo;
	}

	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getMerName() {
		return merName;
	}

	public void setMerName(String merName) {
		this.merName = merName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Double getCreditRate() {
		return creditRate;
	}

	public void setCreditRate(Double creditRate) {
		this.creditRate = creditRate;
	}

	public Double getCreditFee() {
		return creditFee;
	}

	public void setCreditFee(Double creditFee) {
		this.creditFee = creditFee;
	}

	public Double getHistoryTotal() {
		return historyTotal;
	}

	public void setHistoryTotal(Double historyTotal) {
		this.historyTotal = historyTotal;
	}

	public String getReferrer() {
		return referrer;
	}

	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}

	public String getAttenState() {
		return attenState;
	}

	public void setAttenState(String attenState) {
		this.attenState = attenState;
	}

	public String getTiedCard() {
		return tiedCard;
	}

	public void setTiedCard(String tiedCard) {
		this.tiedCard = tiedCard;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}