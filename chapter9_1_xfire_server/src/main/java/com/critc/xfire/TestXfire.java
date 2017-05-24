package com.critc.xfire;

import org.codehaus.xfire.client.Client;

import java.net.URL;

/**
 * Author  孔垂云
 * Date  2017/5/25.
 */
public class TestXfire {

    public static void main(String[] args) {
        try {
            Client client = new Client(new URL("http://localhost:8080/services/FirstService?wsdl"));
            Object[] results = client.invoke("sayHello", new Object[] { "张三" });
            System.out.println((String) results[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
