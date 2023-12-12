package com.ggh.wxgzh.common;

import com.ggh.wxgzh.bean.replyMessageBean.ReplyTextMessageBean;
import com.thoughtworks.xstream.XStream;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class JavaBeanToXml {

    public static String wxRespondUserTextInfoConvert_Xml(ReplyTextMessageBean respondUserTextInfo){
        XStream xstream = new XStream();
        xstream.processAnnotations(ReplyTextMessageBean.class);
        String xml = xstream.toXML(respondUserTextInfo);
        log.info("转成xml：{}",xml);
        return xml;
    }
}
