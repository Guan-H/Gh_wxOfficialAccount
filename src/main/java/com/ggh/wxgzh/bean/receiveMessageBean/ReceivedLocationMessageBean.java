package com.ggh.wxgzh.bean.receiveMessageBean;

import lombok.Data;

/**
 *  地理位置消息
 *
 */
@Data
public class ReceivedLocationMessageBean {
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
     * 消息类型，地理位置为location
     */
    private String msgType;

    /**
     * 地理位置纬度
     */
    private String locationX;

    /**
     * 地理位置经度
     */
    private String locationY;

    /**
     * 地图缩放大小
     */
    private int scale;

    /**
     * 地理位置信息
     */
    private String label;

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

