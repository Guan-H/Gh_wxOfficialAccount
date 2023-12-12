package com.ggh.wxgzh.bean.replyMessageBean;

import lombok.Data;

import java.util.List;

/**
 * 回复图文消息Bean
 */
@Data
public class ReplyNewsMessageBean {
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
     * 消息类型，图文为news
     */
    private String msgType;

    /**
     * 图文消息个数；最多可回复8条图文消息
     */
    private int articleCount;

    /**
     * 图文消息信息
     */
    private List<Article> articles;

    /**
     * 图文消息内容
     */
    @Data
    public class Article {
        /**
         * 图文消息标题
         */
        private String title;

        /**
         * 图文消息描述
         */
        private String description;

        /**
         * 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
         */
        private String picUrl;

        /**
         * 点击图文消息跳转链接
         */
        private String url;
    }

}

