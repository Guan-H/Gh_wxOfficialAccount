package com.ggh.wxgzh.common;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 接入概述
 * 接入微信公众平台开发，开发者需要按照如下步骤完成：
 * 1、填写服务器配置
 * 2、验证服务器地址的有效性
 * 3、依据接口文档实现业务逻辑
 *  这个方法实现第二步，验证服务器地址的有效性
 */
@Slf4j
public class checkWxInfo {


    /**
     * 验证消息的确
     * @param signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @param echostr 随机字符串
     * @return 返回结果
     */
    public static  String wxCheck(String signature,String timestamp, String nonce,String echostr,String wxToken){
        //1）将token、timestamp、nonce三个参数进行字典序排序
        String[] strArr = new String[]{timestamp,nonce,wxToken};
        Arrays.sort(strArr);
        System.out.println("字典排序："+Arrays.toString(strArr));

        //2）将三个参数字符串拼接成一个字符串进行sha1加密
        //2.1)将三个参数字符串拼接成一个字符串
        StringBuilder content = new StringBuilder();
        for (String str : strArr) {
            content.append(str);
        }
        try {
            //2.2) sha1加密
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] bytes = content.toString().getBytes();
            byte[] digestBytes = digest.digest(bytes);
            //将加密后的字节数组转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : digestBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            String countString = hexString.toString();

            //3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
            log.info("开始验证");
            if(signature.equals(countString)){
                log.info("原字符串：{}",signature);
                log.info("结算结果：{}",countString);
                log.info("计算结果一致");
                return echostr;
            }else{
                log.info("原字符串：{}",signature);
                log.info("结算结果：{}",countString);
                log.info("计算结果不一致");
                return "";
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
