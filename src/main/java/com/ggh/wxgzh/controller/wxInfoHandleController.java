package com.ggh.wxgzh.controller;


import cn.hutool.http.HttpUtil;
import com.ggh.wxgzh.bean.wxBean;
import com.ggh.wxgzh.bean.receiveMessageBean.ReceivedTextMessageBean;
import com.ggh.wxgzh.bean.replyMessageBean.ReplyTextMessageBean;
import com.ggh.wxgzh.service.wxIService;
import com.thoughtworks.xstream.XStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.util.Objects;

import static com.ggh.wxgzh.common.JavaBeanToXml.wxRespondUserTextInfoConvert_Xml;
import static com.ggh.wxgzh.common.XmlToJavaBean.XmlConvert_wxRequestUserTextInfo;
import static com.ggh.wxgzh.common.XmlToJavaBean.getNodeValue;
import static com.ggh.wxgzh.common.checkWxInfo.wxCheck;

@Slf4j
@RestController
@RequestMapping("/wx")
public class wxInfoHandleController {


    @Value("${wx.mp.token}")
    private String wxToken;

    @Value("${wx.mp.appId}")
    private String appId;

    @Value("${wx.mp.secret}")
    private String secret;


    @Autowired
    private wxIService wxService;


    /**
     * 验证消息的确来自微信服务器
     *
     * @param wx      微信验证对象
     * @param request request
     * @return 返回结果
     */
    @GetMapping("/")
    public String wxGet(wxBean wx, HttpServletRequest request) {
        //获取Access token
        String s = HttpUtil.get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret=" + secret);
        log.info("token");

        return wxCheck(wx.getSignature(), wx.getTimestamp(), wx.getNonce(), wx.getEchostr(), wxToken);
    }

    @PostMapping(value = "/")
    public String getUserReqInfo(HttpServletRequest request) throws IOException, ParserConfigurationException, SAXException {
        ServletInputStream inputStream = request.getInputStream();
        //微信服务端发来的XML格式信息转换成java对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputStream);
        Element root = document.getDocumentElement();
        String msgType = getNodeValue(root, "MsgType");
        String xml = "";
        if(StringUtils.isNoneBlank(msgType)){
            switch (msgType){
                case "text":
                    ReceivedTextMessageBean ReceivedTextMessageBean = XmlConvert_wxRequestUserTextInfo(document);
                    log.info("requestInfo:{}", ReceivedTextMessageBean);
                    //处理客户端发来的信息
                    ReplyTextMessageBean replyTextMessageBean = wxService.handleRequest(ReceivedTextMessageBean);
                     xml = wxRespondUserTextInfoConvert_Xml(replyTextMessageBean);
                    break;
                case "image":
                    break;
                case "event":
                    break;
                default:break;
            }
        }
        //关闭流
        inputStream.close();
        //将处理完成的对象转换成XML格式发回给微信服务器
        return xml;
    }


}
