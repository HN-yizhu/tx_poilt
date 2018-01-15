package com.poilt.enums;

public enum BankCodeEnum {
	
	E102	("102","ICBC","中国工商银行"),
	E103	("103","ABC","中国农业银行"),
	E104	("104","BOC","中国银行"),
	E105	("105","CCB","中国建设银行"),
	E201	("201","CDB","国家开发银行"),
	E202	("202","EXIMBANK","中国进出口银行"),
	E203	("203","ADBC","中国农业发展银行"),
	E301	("301","BCOM","交通银行"),
	E302	("302","CITIC","中信银行"),
	E303	("303","CEB","中国光大银行"),
	E304	("304","HXB","华夏银行"),
	E305	("305","CMBC","中国民生银行"),
	E306	("306","CGB","广东发展银行"),
	E307	("307","PAB","平安银行"),
	E308	("308","CMB","招商银行"),
	E309	("309","CIB","兴业银行"),
	E310	("310","SPDB","上海浦东发展银行"),
	E312	("313","BIN","宁波国际银行"),
	E314	("314","BRCB","北京农村商业银行"),
	E315	("315","EGBANK","恒丰银行"),
	E316	("316","CZB","浙商银行"),
	E317	("317","BOB","北京银行"),
	E318	("318","HCCB","杭州银行"),
	E319	("319","NJCB","南京银行"),
	E403	("403","PSBC","中国邮政储蓄银行"),
	E501	("501","HSBC","汇丰银行"),
	E502	("502","HKBEA","东亚银行"),
	E503	("503","NCBCHINA","南洋商业银行"),
	E504	("504","HANGSENG","恒生银行"),
	E783	("783","SDB","深圳发展银行"),
	E905	("905","UNIONPAY","中国银联");
	
	private String code;
	private String ename;
	private String name;
	private BankCodeEnum(String code,String ename,String name) {
		
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
