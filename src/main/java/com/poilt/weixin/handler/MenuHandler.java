package com.poilt.weixin.handler;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

import com.poilt.weixin.builder.TextBuilder;

import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.MenuButtonType;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MenuHandler extends AbstractHandler {

  @Override
  public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                  Map<String, Object> context, WxMpService weixinService,
                                  WxSessionManager sessionManager) {

    /*String msg = String.format("type:%s, event:%s, key:%s",
        wxMessage.getMsgType(), wxMessage.getEvent(),
        wxMessage.getEventKey());*/
    
    if (MenuButtonType.VIEW.equals(wxMessage.getEvent())) {
      return null;
    }
    String eventKey = wxMessage.getEventKey();
	logger.info(eventKey);
	if("CREDIT_CARD".equals(eventKey)){
		return new TextBuilder().build("服务暂未上线,敬请关注！", wxMessage, weixinService);
	}

    return WxMpXmlOutMessage.TEXT().content("感谢您关注，请点击<我要收款>，你懂的...")
        .fromUser(wxMessage.getToUser()).toUser(wxMessage.getFromUser())
        .build();
  }

}
