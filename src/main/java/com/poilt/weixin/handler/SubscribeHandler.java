package com.poilt.weixin.handler;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.poilt.model.fastpay.Merch;
import com.poilt.service.fastpay.MerchService;
import com.poilt.weixin.builder.TextBuilder;
import java.util.Map;

/**
 * 
 * Title: SubscribeHandler
 * Description: 
 * Date: 2018年1月11日 下午12:12:38
 * @author: TanGuobiao
 *
 */
@Component
public class SubscribeHandler extends AbstractHandler {

	@Autowired
	private MerchService merchService;
	
	/* (non-Javadoc)
	 * @see me.chanjar.weixin.mp.api.WxMpMessageHandler#handle(me.chanjar.weixin.mp.bean.message.WxMpXmlMessage, java.util.Map, me.chanjar.weixin.mp.api.WxMpService, me.chanjar.weixin.common.session.WxSessionManager)
	 */
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService weixinService,
			WxSessionManager sessionManager) throws WxErrorException {

		this.logger.info("新关注用户 OPENID: " + wxMessage.getFromUser());
		
		// 获取微信用户基本信息
		WxMpUser userWxInfo = weixinService.getUserService().userInfo(wxMessage.getFromUser(), null);

		if (userWxInfo != null) {
			Merch user = merchService.findByOpenId(userWxInfo.getOpenId());
			if (user == null) {
				//添加关注用户到本地
				Merch merch = new Merch();
				merch.setMerName(userWxInfo.getNickname());
				merch.setOpenId(userWxInfo.getOpenId());
				try {
					merchService.insert(merch);
				} catch (Exception e) {
					this.logger.error("关注用户到本地异常", e);
				}
			} else {
				if("N".equals(user.getAttenState())){
					//更新本地数据库为关注状态
					Merch merch = new Merch();
					merch.setOpenId(userWxInfo.getOpenId());
					merch.setAttenState("Y");
					try {
						merchService.updateByOpenId(merch);
					} catch (Exception e) {
						this.logger.error("修改关注状态异常", e);
					}
				}
			}
		}

		WxMpXmlOutMessage responseResult = null;
		try {
			responseResult = handleSpecial(wxMessage);
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
		}

		if (responseResult != null) {
			return responseResult;
		}

		try {
			return new TextBuilder().build("感谢您关注，请点击<我要收款>，你懂的...", wxMessage, weixinService);
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
		}

		return null;
	}

	/**
	 * 处理特殊请求，比如如果是扫码进来的，可以做相应处理
	 */
	private WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage) throws Exception {
		// TODO
		return null;
	}

}
