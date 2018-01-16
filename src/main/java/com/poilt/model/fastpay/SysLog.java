package com.poilt.model.fastpay;

import java.util.Date;

public class SysLog {
    private Integer id;

    private String userId;

    private String userName;

    private String tradeNo;

    private String tradeType;

    private String reqParam;

    private String respResult;

    private Date createTim;

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

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType == null ? null : tradeType.trim();
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}