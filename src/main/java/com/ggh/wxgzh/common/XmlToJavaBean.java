package com.ggh.wxgzh.common;

import com.ggh.wxgzh.bean.receiveMessageBean.ReceivedTextMessageBean;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;

public class XmlToJavaBean {


    public static ReceivedTextMessageBean XmlConvert_wxRequestUserTextInfo(Document document) throws IOException {
        ReceivedTextMessageBean requestInfo = new ReceivedTextMessageBean();

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
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return null;
    }

}
