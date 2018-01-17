package com.poilt.web.controller.fastpay.api;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.poilt.enums.StatusCode;
import com.poilt.exception.JsonException;
import com.poilt.exception.Result;
import com.poilt.model.fastpay.Merch;
import com.poilt.service.fastpay.BankCodeService;
import com.poilt.service.fastpay.MerchService;
import com.poilt.utils.WebUtils;

/**
 * 商户注册
 * 
 * @author Administrator
 *
 */
@Controller
public class MerchRegisterController {

	private static final Logger logger = LoggerFactory.getLogger(MerchRegisterController.class);

	@Autowired
	private MerchService merchService;
	
	@Autowired
	private BankCodeService bankCodeService;
	
	@RequestMapping("/fastpay_register")
	public String merch(Merch merch, HttpSession httpSession, Model model) throws Exception {
		logger.info("[接收到实体]\r\n{}", JSONObject.toJSONString(merch));
		String openId = WebUtils.getSessionValue("openId");
		if("".equals(openId)){
			throw new Exception("openId获取失败！");
		}else{
			merch.setOpenId(openId);
			merchService.updateByOpenId(merch);
		}
		List<Map<String, Object>> list = bankCodeService.selectMap();
		model.addAttribute("bankCodeList", list);
		return "/tiedCard";
	}
	
	@ResponseBody
	@RequestMapping("/fastpay_merch_update")
	public Result<String> merchUpdate(Merch merch) throws JsonException {
		try {
			String openId = WebUtils.getSessionValue("openId");
			if("".equals(openId)){
				throw new JsonException(StatusCode.SYS_NO_OPEN_ID);
			}else{
				merch.setOpenId(openId);
				merchService.updateByOpenId(merch);
			}
		} catch (JsonException e){
			throw e;
		} catch (Exception e) {
			throw new JsonException(StatusCode.SYS_ERR);
		}
		return new Result<String>("");
	}

}
