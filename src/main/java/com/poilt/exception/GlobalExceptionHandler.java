package com.poilt.exception;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	/**
	 * JSON返回格式异常处理
	 * @param request
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value=JsonException.class)
	public Result<String> jsonExceptionHandler(HttpServletRequest request, JsonException e){
		return new Result<String>(e.getCode(), e.getMessage(), "");
	}
	
	/**
	 * 系统全局异常
	 * @param request
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value=Exception.class)
	public String exceptionHandler(HttpServletRequest request, Exception e) throws Exception{
		logger.error("[Exception]", e);
		return "/error";
	}
	
}
