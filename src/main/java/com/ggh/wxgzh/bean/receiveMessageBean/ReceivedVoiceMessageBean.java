package com.ggh.wxgzh.bean.receiveMessageBean;

import lombok.Data;

/**
 * 语音消息
 */

@Data
public class ReceivedVoiceMessageBean {

    /**
     * 开发者微信号
     */
    private String toUserName;

    /**
     * 发送方账号（一个OpenID）
     */
    private String fromUserName;

    /**
     * 消息创建时间 （整型）
     */
    private long createTime;

    /**
     * 消息类型，语音为voice
     */
    private String msgType;

    /**
     * 语音消息媒体id，可以调用获取临时素材接口拉取数据
     */
    private String mediaId;

    /**
     * 语音格式，如amr，speex等
     */
    private String format;

    /**
     * 消息id，64位整型
     */
    private long msgId;

    /**
     * 消息的数据ID（消息如果来自文章时才有）
     */
    private String msgDataId;

    /**
     * 多图文时第几篇文章，从1开始（消息如果来自文章时才有）
     */
    private int idx;
}
