package com.poilt.pojo;

import java.util.Date;

public class User {
	
	private Integer id;
	
	private String wxId;

	private String userName;

	private String userAlias;

	private String userCertNo;

	private String openId;

	private String creditRate;

	private Integer historyTotal;

	private String userNo;

	private String userUuid;

	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias == null ? null : userAlias.trim();
	}

	public String getUserCertNo() {
		return userCertNo;
	}

	public void setUserCertNo(String userCertNo) {
		this.userCertNo = userCertNo == null ? null : userCertNo.trim();
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

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo == null ? null : userNo.trim();
	}

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid == null ? null : userUuid.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getWxId() {
		return wxId;
	}

	public void setWxId(String wxId) {
		this.wxId = wxId;
	}
}