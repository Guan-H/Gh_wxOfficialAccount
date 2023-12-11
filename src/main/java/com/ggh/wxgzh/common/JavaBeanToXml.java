package com.ggh.wxgzh.common;

import com.ggh.wxgzh.bean.wxRespondUserTextInfo;
import com.thoughtworks.xstream.XStream;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class JavaBeanToXml {

    public static String wxRespondUserTextInfoConvert_Xml(wxRespondUserTextInfo respondUserTextInfo){
        XStream xstream = new XStream();
        xstream.processAnnotations(wxRespondUserTextInfo.class);
        String xml = xstream.toXML(respondUserTextInfo);
        log.info("转成xml：{}",xml);
        return xml;
    }
}
