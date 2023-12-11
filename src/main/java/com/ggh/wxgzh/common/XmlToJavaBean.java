package com.ggh.wxgzh.common;

import com.ggh.wxgzh.bean.wxRequestUserTextInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XmlToJavaBean {


    public static wxRequestUserTextInfo XmlConvert_wxRequestUserTextInfo(Document document) throws IOException {
        wxRequestUserTextInfo requestInfo = new wxRequestUserTextInfo();

        Element root = document.getDocumentElement();

        // 获取XML节点的值并设置到Java对象中
        requestInfo.setToUserName(getNodeValue(root, "ToUserName"));
        requestInfo.setFromUserName(getNodeValue(root, "FromUserName"));
        requestInfo.setMsgDataId(getNodeValue(root, "MsgDataId"));
        requestInfo.setMsgType(getNodeValue(root, "MsgType"));
        requestInfo.setContent(getNodeValue(root, "Content"));

        String msgIdValue = getNodeValue(root, "MsgId");
        if (msgIdValue != null) {
            requestInfo.setMsgId(Long.parseLong(msgIdValue));
        } else {
            // 处理节点值为空的情况，例如设置默认值或抛出异常
            requestInfo.setMsgId(-1L);
        }
        String createTimeValue = getNodeValue(root, "CreateTime");
        if (createTimeValue != null) {
            requestInfo.setCreateTime(Long.parseLong(createTimeValue));
        } else {
            // 处理节点值为空的情况，例如设置默认值或抛出异常
            requestInfo.setCreateTime(-1L);
        }

        String idxValue = getNodeValue(root, "Idx");
        if (idxValue != null) {
            requestInfo.setIdx(Integer.parseInt(idxValue));
        } else {
            // 处理节点值为空的情况，例如设置默认值或抛出异常
            requestInfo.setIdx(-1);
        }

        return requestInfo;

    }

    // 辅助方法，用于获取XML节点的值
    public static String getNodeValue(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList != null && nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return null;
    }

}
