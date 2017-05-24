package com.critc.cxf;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import javax.xml.namespace.QName;

/**
 * Author  孔垂云
 * Date  2017/5/25.
 */
public class TestCxf {

    public static void main(String[] args) {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client = dcf
                .createClient("http://localhost:8080/services/cxfService?wsdl");
        // url为调用webService的wsdl地址
        QName name = new QName("http://cxf.critc.com/", "sayHello");
        // namespace是命名空间，methodName是方法名
        String xmlStr = "张三";
        // paramvalue为参数值
        Object[] objects;
        try {
            objects = client.invoke(name, xmlStr);
            System.out.println(objects[0].toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
