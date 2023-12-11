package com.ggh.wxgzh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ggh.wxgzh.bean.wxBean;
import com.ggh.wxgzh.bean.wxRequestUserTextInfo;
import com.ggh.wxgzh.bean.wxRespondUserTextInfo;
import com.ggh.wxgzh.mapper.wxMapper;

public interface wxIService extends IService<wxBean> {
    wxRespondUserTextInfo handleRequest(wxRequestUserTextInfo wxRequestUserTextInfo);
}
