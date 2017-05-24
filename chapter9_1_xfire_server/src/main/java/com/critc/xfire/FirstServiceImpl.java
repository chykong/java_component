package com.critc.xfire;

/**
 * Author  孔垂云
 * Date  2017/5/25.
 */
public class FirstServiceImpl implements FirstService {

    public String sayHello(String name) {
        return "hello:" + name;
    }
}
