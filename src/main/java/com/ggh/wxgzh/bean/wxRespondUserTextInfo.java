package com.ggh.wxgzh.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 *  用户发送消息给公众号时，服务端回复给用户的对象
 *  该回复默认消息类型是：TEXT类型
 */
@Data
@XStreamAlias("xml")
public class wxRespondUserTextInfo {

    /**
     * 接收方账号（收到的OpenID）
     */
    private String ToUserName;

    /**
     * 开发者微信号
     */
    private String FromUserName;

    /**
     * 消息创建时间 （整型）
     */
    private Long CreateTime;

    /**
     * 消息类型，
     */
    private String MsgType;

    /**
     * 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
     */
    private String Content;
}
