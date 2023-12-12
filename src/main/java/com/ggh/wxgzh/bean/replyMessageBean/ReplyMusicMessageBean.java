package com.ggh.wxgzh.bean.replyMessageBean;

import lombok.Data;

/**
 * 回复音乐消息Bean
 */
@Data
public class ReplyMusicMessageBean {
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
     * 消息类型，音乐为music
     */
    private String msgType;

    /**
     * 音乐标题
     */
    private String title;

    /**
     * 音乐描述
     */
    private String description;

    /**
     * 音乐链接
     */
    private String musicURL;

    /**
     * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
     */
    private String hQMusicUrl;

    /**
     * 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
     */
    private String thumbMediaId;
}

