package com.ggh.wxgzh.bean.menuBean;


import lombok.Data;

import java.util.List;

/**
 *  自定义菜单对象
 */
@Data
public class buttonBean {

    private String name; // 菜单标题，不超过16个字节，子菜单不超过60个字节

    private String type; // 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型

    private String key; // 菜单KEY值，用于消息接口推送，不超过128字节

    private List<buttonBean> sub_button; // 二级菜单数组，个数应为1~5个

    private String media_id; // 调用新增永久素材接口返回的合法media_id

    private String article_id; // 发布后获得的合法 article_id

    private String url; // 网页链接，用户点击菜单可打开链接，不超过1024字节。 type为miniprogram时，不支持小程序的老版本客户端将打开本url。

    private String pagepath; // 小程序的页面路径

    private String appid; // 小程序的appid（仅认证公众号可配置）

    private String value; // 值
}
