package com.ggh.wxgzh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ggh.wxgzh.bean.wxBean;
import com.ggh.wxgzh.bean.receiveMessageBean.ReceivedTextMessageBean;
import com.ggh.wxgzh.bean.replyMessageBean.ReplyTextMessageBean;
import com.ggh.wxgzh.mapper.wxMapper;
import com.ggh.wxgzh.service.wxIService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class wxServiceImpl extends ServiceImpl<wxMapper, wxBean> implements wxIService {


    @Resource
    private wxMapper wxmapper;

    @Override
    public ReplyTextMessageBean handleRequest(ReceivedTextMessageBean ReceivedTextMessageBean) {
        ReplyTextMessageBean respondUserTextInfo = new ReplyTextMessageBean();
        respondUserTextInfo.setToUserName(ReceivedTextMessageBean.getFromUserName());
        respondUserTextInfo.setFromUserName(ReceivedTextMessageBean.getToUserName());
        respondUserTextInfo.setCreateTime(System.currentTimeMillis()/1000);
        respondUserTextInfo.setMsgType("text");
        respondUserTextInfo.setContent("我是石页");
        return respondUserTextInfo;
    }
}
