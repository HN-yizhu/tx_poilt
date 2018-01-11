package com.poilt.weixin.handler;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.poilt.weixin.builder.TextBuilder;

import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType;

/**
 * 
 * Title: MsgHandler
 * Description: 
 * Date: 2018年1月11日 下午4:10:28
 * @author: TanGuobiao
 *
 */
@Component
public class MsgHandler extends AbstractHandler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService weixinService,
			WxSessionManager sessionManager) {

		if (!wxMessage.getMsgType().equals(XmlMsgType.EVENT)) {
			//将消息保存到本地
		}
		
		// 当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
		/*try {
			if (StringUtils.startsWithAny(wxMessage.getContent(), "你好", "客服")
					&& weixinService.getKefuService().kfOnlineList().getKfOnlineList().size() > 0) {
				return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE().fromUser(wxMessage.getToUser())
						.toUser(wxMessage.getFromUser()).build();
			}
		} catch (WxErrorException e) {
			e.printStackTrace();
		}*/

		//组装回复消息
		//String content = "收到信息内容：" + JsonUtils.toJson(wxMessage);
		String content = "感谢您关注，请点击<我要收款>，你懂的...";

		return new TextBuilder().build(content, wxMessage, weixinService);

	}

}
