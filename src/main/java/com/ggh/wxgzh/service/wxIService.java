package com.ggh.wxgzh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ggh.wxgzh.bean.wxBean;
import com.ggh.wxgzh.bean.receiveMessageBean.ReceivedTextMessageBean;
import com.ggh.wxgzh.bean.replyMessageBean.ReplyTextMessageBean;

public interface wxIService extends IService<wxBean> {
    ReplyTextMessageBean handleRequest(ReceivedTextMessageBean ReceivedTextMessageBean);
}
