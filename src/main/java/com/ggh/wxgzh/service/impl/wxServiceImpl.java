package com.ggh.wxgzh.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ggh.wxgzh.bean.wxBean;
import com.ggh.wxgzh.bean.receiveMessageBean.ReceivedTextMessageBean;
import com.ggh.wxgzh.bean.replyMessageBean.ReplyTextMessageBean;
import com.ggh.wxgzh.common.httpUtils;
import com.ggh.wxgzh.mapper.wxMapper;
import com.ggh.wxgzh.service.wxIService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

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


    /**
     *
     * @param word 要查询的词语，
     * @param key  在个人中心->我的数据,接口名称上方查看
     * @param type  查询类型，1:同义词 2:反义词，默认1
     * @return
     */
    public String getTyfy(String word, String key, String type){
        if(StringUtils.isEmpty(type)){
            type = "1";
        }
        String url = "http://apis.juhe.cn/tyfy/query?type="+type+"&key="+key+"&word="+word;
        String result = httpUtils.doGet(url);
        Map map = JSONObject.parseObject(result, Map.class);

        return result;
    }
}
