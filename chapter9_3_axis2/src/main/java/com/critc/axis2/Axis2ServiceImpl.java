package com.critc.axis2;

/**
 * Author  孔垂云
 * Date  2017/5/25.
 */
public class Axis2ServiceImpl implements  Axis2Service{
    public String sayHello(String name) {
        return "hello： " + name;
    }
}
