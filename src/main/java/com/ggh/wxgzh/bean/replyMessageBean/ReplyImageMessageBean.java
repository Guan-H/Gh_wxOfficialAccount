package com.ggh.wxgzh.bean.replyMessageBean;

import lombok.Data;

/**
 * 回复图片消息Bean
 */
@Data
public class ReplyImageMessageBean {
    /**
     * 接收方账号（收到的OpenID）
     */
    private String toUserName;

    /**
     * 开发者微信号
     */
    private String fromUserName;

    /**
     * 消息创建时间 （整型）
     */
    private long createTime;

    /**
     * 消息类型，图片为image
     */
    private String msgType;

    /**
     * 通过素材管理中的接口上传多媒体文件，得到的id
     */
    private String mediaId;

}
