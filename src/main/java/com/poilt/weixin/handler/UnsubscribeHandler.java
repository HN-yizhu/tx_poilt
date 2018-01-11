package com.poilt.weixin.handler;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poilt.model.fastpay.Merch;
import com.poilt.service.fastpay.MerchRegisterService;

import java.util.Map;

/**
 * 
 * Title: UnsubscribeHandler
 * Description: 
 * Date: 2018年1月11日 下午2:12:26
 * @author: TanGuobiao
 *
 */
@Component
public class UnsubscribeHandler extends AbstractHandler {

	@Autowired
	private MerchRegisterService merchRegisterService;

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) {
		String openId = wxMessage.getFromUser();
		this.logger.info("取消关注用户 OPENID: " + openId);
		//更新本地数据库为取消关注状态
		Merch merch = new Merch();
		merch.setOpenId(openId);
		merch.setAttenState("N");
		try {
			merchRegisterService.updateByOpenId(merch);
		} catch (Exception e) {
			this.logger.error("修改关注状态异常", e);
		}
		return null;
	}

}
