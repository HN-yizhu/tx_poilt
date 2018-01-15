package com.poilt.enums;

/**
 * ClassName: StatusCode
 * Version: 1.0.0
 * Date: 2017-12-04
 * Copyright: TanGuobiao
 */
public enum StatusCode {

	/**
	 * [200]成功
	 */
	SUCC_200("200", "成功"),
	/**
	 * [0100]系统异常
	 */
	SYS_ERR("0100", "系统异常"),
	/**
	 * [0101]数据库操作失败
	 */
	SYS_DB_ERR("0101", "数据库操作失败"),
	/**
	 * [0102]微信openId获取失败
	 */
	SYS_NO_OPEN_ID("0102", "微信openId获取失败"),
	/**
	 * [0103]绑卡异常
	 */
	SYS_MSG_TIED_CARD("0103", "绑卡异常");
	
	private String code;
	private String desc;

	private StatusCode(String code, String desc) {
		this.setCode(code);
		this.setDesc(desc);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return "[" + this.code + "]" + this.desc;
	}
}
