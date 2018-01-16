package com.poilt.weixin.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.poilt.model.fastpay.Merch;
import com.poilt.service.fastpay.BankCodeService;
import com.poilt.service.fastpay.MerchService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * 
 * Title: WechatUrlController.java
 * Description: 
 * Date: 2018年1月16日
 * @author: TanGuobiao
 *
 */
@Controller
@RequestMapping("/wechat/url")
public class WechatUrlController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WxMpService wxMpService;
	
	@Autowired
	private MerchService merchService;
	
	@Autowired
	private BankCodeService bankCodeService;
	
	@PostMapping
	public String post(@RequestParam(name = "code", required = true) String code) {
		logger.info("wechat post : " + code);
		return "/index";
	}
	
	/**
SNSAPI_BASE URL:[https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx45da44ed1dfa99c5&redirect_uri=https%3A%2F%2Fpay.masduo.com%2Fwechat%2Furl&response_type=code&scope=snsapi_base&state=#wechat_redirect]
SNSAPI_BASE URL:[https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx45da44ed1dfa99c5&redirect_uri=https%3A%2F%2Fpay.masduo.com%2Fwechat%2Furl&response_type=code&scope=snsapi_userinfo&state=#wechat_redirect]
 	 String url = "https://pay.masduo.com/wechat/url";
		String baseUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_BASE, null);
		logger.info("SNSAPI_BASE URL:[" + baseUrl + "]");
		String userInfoUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
		logger.info("SNSAPI_BASE URL:[" + userInfoUrl + "]");
		try {
			logger.info("wechat redirect code : " + code);
			WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
			logger.info("wechat access token's openId:" + wxMpOAuth2AccessToken.getOpenId());
			//WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
			//logger.info(wxMpUser.toString());
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
	 * @return
	 * @throws Exception 
	 */
	@GetMapping
	public String get(@RequestParam(name = "code", required = true) String code, HttpSession httpSession, Map<String, Object> map) throws Exception {
		WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
		String openId = wxMpOAuth2AccessToken.getOpenId();
		if(openId == null || "".equals(openId)){
			throw new Exception("请从微信公众号进行访问!");
		}
		httpSession.setAttribute("openId", openId);
		/*是否已经注册*/
		Merch merch = merchService.findByOpenId(openId);
		if(merch == null){
			WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
			merch = new Merch();
			merch.setOpenId(openId);
			merch.setMerName(wxMpUser.getNickname());
			merchService.insert(merch);
		}
		String tiedCard = merch.getTiedCard();
		String idCard = merch.getIdCard();
		if(idCard == null || "".equals(idCard)){
			return "/register";
		} else if(tiedCard == null || "N".equals(tiedCard) || "".equals(tiedCard)) {
			List<Map<String, Object>> list = bankCodeService.selectMap();
			map.put("bankCodeList", list);
			return "/tiedCard";
		} else {
			List<Map<String, Object>> list = bankCodeService.selectMap();
			map.put("bankCodeList", list);
			return "/index";
		}
	}
	
	
}
