package com.ggh.wxgzh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ggh.wxgzh.bean.wxBean;
import com.ggh.wxgzh.bean.wxRequestUserTextInfo;
import com.ggh.wxgzh.bean.wxRespondUserTextInfo;
import com.ggh.wxgzh.mapper.wxMapper;
import com.ggh.wxgzh.service.wxIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class wxServiceImpl extends ServiceImpl<wxMapper, wxBean> implements wxIService {


    @Resource
    private wxMapper wxmapper;

    @Override
    public wxRespondUserTextInfo handleRequest(wxRequestUserTextInfo wxRequestUserTextInfo) {
        wxRespondUserTextInfo respondUserTextInfo = new wxRespondUserTextInfo();
        respondUserTextInfo.setToUserName(wxRequestUserTextInfo.getFromUserName());
        respondUserTextInfo.setFromUserName(wxRequestUserTextInfo.getToUserName());
        respondUserTextInfo.setCreateTime(System.currentTimeMillis()/1000);
        respondUserTextInfo.setMsgType("text");
        respondUserTextInfo.setContent("我是石页");
        return respondUserTextInfo;
    }
}
