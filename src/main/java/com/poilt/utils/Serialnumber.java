package com.poilt.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Serialnumber {

	/**
	 * 获取流水号
	 * 
	 * @return返回字符串格式yyyyMMddHHmmssSSS
	 */
	public static String getSerial() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String dateString = formatter.format(currentTime);
		int x = (int) (Math.random() * 900) + 100;
		String serial = dateString + x;
		return serial;
	}

	// 主方法测试
	public static void main(String[] args) {
		String m = getSerial();
		System.out.println(m);
	}

}
