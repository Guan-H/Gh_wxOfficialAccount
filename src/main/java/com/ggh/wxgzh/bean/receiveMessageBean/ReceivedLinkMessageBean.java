package com.ggh.wxgzh.bean.receiveMessageBean;

import lombok.Data;

/**
 * 链接消息
 */
@Data
public class ReceivedLinkMessageBean {
    /**
     * 接收方微信号
     */
    private String toUserName;

    /**
     * 发送方微信号，若为普通用户，则是一个OpenID
     */
    private String fromUserName;

    /**
     * 消息创建时间
     */
    private long createTime;

    /**
     * 消息类型，链接为link
     */
    private String msgType;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息描述
     */
    private String description;

    /**
     * 消息链接
     */
    private String url;

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

