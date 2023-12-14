package com.ggh.wxgzh.test;

import com.ggh.wxgzh.bean.menuBean.buttonBean;

import java.util.ArrayList;
import java.util.List;

public class testMain {

    public static void main(String[] args) {
        buttonBean clickButton = new buttonBean();
        clickButton.setType("click");
        clickButton.setName("菜单1");
        clickButton.setKey("menu1");

        buttonBean clickButton2 = new buttonBean();
        clickButton2.setType("click");
        clickButton2.setName("菜单2");
        clickButton2.setKey("menu2");

        buttonBean clickButton3 = new buttonBean();

        buttonBean view = new buttonBean();
        view.setType("view");
        view.setName("百度");
        view.setKey("https://www.baidu.com");

        List<buttonBean> sub_button = new ArrayList<>();
        sub_button.add(view);

        clickButton3.setSub_button(sub_button);






    }
}
