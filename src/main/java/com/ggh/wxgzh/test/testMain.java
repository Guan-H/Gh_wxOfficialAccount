package com.ggh.wxgzh.test;

import cn.hutool.http.HttpUtil;
import com.ggh.wxgzh.bean.menuBean.Button;
import com.ggh.wxgzh.bean.menuBean.buttonBean;
import com.ggh.wxgzh.common.httpUtils;
import com.thoughtworks.xstream.XStream;
import net.sf.json.JSONObject;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class testMain {

    public static void main(String[] args) {


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


    }
}
