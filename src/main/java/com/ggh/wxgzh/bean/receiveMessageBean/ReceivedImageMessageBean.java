package com.ggh.wxgzh.bean.receiveMessageBean;

import lombok.Data;


/**
 * 图片消息
 */
@Data
public class ReceivedImageMessageBean {

    /**
     * 消息接收方的微信号，即公众号的微信号
     */
    private String toUserName;

    /**
     * 发送方的账号，即发送消息的用户的 OpenID
     */
    private String fromUserName;

    /**
     * 消息创建时间，以整数表示的时间戳
     */
    private long createTime;

    /**
     * 消息类型，比如图片消息的类型可能为 "image"
     */
    private String msgType;

    /**
     * 图片消息的链接，由微信系统生成
     */
    private String picUrl;

    /**
     * 图片消息的媒体 ID，可用于调用临时素材接口获取数据
     */
    private String mediaId;

    /**
     * 消息的 ID，一般是 64 位整数
     */
    private long msgId;

    /**
     * 消息的数据 ID，在消息来自文章时可能会出现
     */
    private String msgDataId;

    /**
     * 在多图文消息中，表示是第几篇文章，从 1 开始
     */
    private int idx;

}
