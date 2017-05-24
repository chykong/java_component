package com.critc.cxf;

import javax.jws.WebService;

/**
 * Author  孔垂云
 * Date  2017/5/25.
 */
@WebService()
public class CxfServiceImpl {
    public String sayHello(String name) {
        return "hello： " + name;
    }
}
