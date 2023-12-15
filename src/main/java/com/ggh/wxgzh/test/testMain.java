package com.ggh.wxgzh.test;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;
import com.ggh.wxgzh.bean.menuBean.Button;
import com.ggh.wxgzh.bean.menuBean.buttonBean;
import com.ggh.wxgzh.common.httpUtils;
import com.thoughtworks.xstream.XStream;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class testMain {

    public static void main(String[] args) {

        String resp = getTyfy("开心", "1b072cce1259e7c427a7a8575490e584", "2");
        System.out.println("resp = " + resp);

        /*
        String ACCESS_TOKEN = "75_YisyHYWHkmd_Cm4qD9jrmOhEQXf5rhyrTk0bnh3OgJMT2I6_fnH8ep3JfQqWf7oBxQjvSune1Of6wDWtFPHxPu_imRAaGQrT6ptmla_nxJPQKk9LDIWWl7QAvH8FTRdAAAYMK";
        System.out.println("ACCESS_TOKEN = " + ACCESS_TOKEN);

        String url = " https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+ ACCESS_TOKEN;

        Button button = new Button();

        buttonBean clickButton = new buttonBean();
        clickButton.setType("click");
        clickButton.setName("菜单1");
        clickButton.setKey("menu1");

        buttonBean clickButton2 = new buttonBean();
        clickButton2.setType("click");
        clickButton2.setName("菜单2");
        clickButton2.setKey("menu2");

        buttonBean clickButton3 = new buttonBean();
        clickButton3.setName("菜单2");
        List<buttonBean> sub_button = new ArrayList<>();
        buttonBean view = new buttonBean();
        view.setType("view");
        view.setName("百度");
        view.setUrl("https://www.baidu.com");
        sub_button.add(view);
        clickButton3.setSub_button(sub_button);

        List<buttonBean> buttonBeanList = new ArrayList<>();
        buttonBeanList.add(clickButton);
        buttonBeanList.add(clickButton2);
        buttonBeanList.add(clickButton3);

        button.setButton(buttonBeanList);

        JSONObject jsonObject = JSONObject.fromObject(button);
        String param = jsonObject.toString();
        System.out.println("param = " + param);

        String s = httpUtils.doPostByButton(url, param);
        System.out.println("s = " + s);

         */


    }

    public static String getTyfy(String word, String key, String type){
        if(StringUtils.isEmpty(type)){
            type = "1";
        }
        String url = "http://apis.juhe.cn/tyfy/query?type="+type+"&key="+key+"&word="+word;
        String result = httpUtils.doGet(url);
        Map map = JSONObject.parseObject(result, Map.class);
        Object result1 = map.get("result");

        Map<String, Object> resultObject = (Map<String, Object>) result1;
        System.out.println("resultObject = " + resultObject);
        Object words = resultObject.get("words");
        List<String> stringList = (List<String>)words;
        for (String stringWord : stringList) {
            System.out.println("stringWord = " + stringWord);
        }
        System.out.println("===================" );
        System.out.println("map = " + map);
        return result;
    }
}
