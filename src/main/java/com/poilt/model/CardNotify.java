package com.poilt.model;

public class CardNotify {

	private String merNo;
	
	private String merTrace;
	
	private String orderNo;
	
	private String transStatus;

	public String getMerNo() {
		return merNo;
	}

	public void setMerNo(String merNo) {
		this.merNo = merNo;
	}

	public String getMerTrace() {
		return merTrace;
	}

	public void setMerTrace(String merTrace) {
		this.merTrace = merTrace;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getTransStatus() {
		return transStatus;
	}

	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}
	
	@Override
	public String toString() {
		return merNo + "," + merTrace + "," + orderNo + "," + transStatus;
	}
	
}
