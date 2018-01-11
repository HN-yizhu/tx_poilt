package com.poilt.exception;

import com.poilt.enums.StatusCode;

public class Result<T> {

	public Result(T data){
		this.code = StatusCode.SUCC_200.getCode();
		this.message = StatusCode.SUCC_200.getDesc();
		this.data = data;
	}
	public Result(String code, String message, T data){
		this.code = code;
		this.message = message;
		this.data = data;
	}
	private String code;
	private String message;
	private T data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
