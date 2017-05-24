package com.critc.cxf;

import javax.jws.WebService;

/**
 * Author  孔垂云
 * Date  2017/5/25.
 */
@WebService
public interface CxfService {
    public String sayHello(String name);
}
