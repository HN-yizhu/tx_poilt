package com.poilt.exception;

import com.poilt.enums.StatusCode;

/**
 * ClassName: JsonException
 * Version: 1.0.0
 * Date: 2017-12-04
 * Copyright: TanGuobiao
 */
public class JsonException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String desc;
	
	public JsonException(StatusCode status){
		super(status.toString());
		this.setCode(status.getCode());
		this.setDesc(status.getDesc());
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
	
}
