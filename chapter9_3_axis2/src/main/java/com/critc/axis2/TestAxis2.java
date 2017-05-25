package com.critc.axis2;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import javax.xml.namespace.QName;

/**
 * Author  孔垂云
 * Date  2017/5/25.
 */
public class TestAxis2 {

    public static void main(String[] args) throws Exception {
        // 使用RPC方式调用WebService
        RPCServiceClient serviceClient = new RPCServiceClient();
        Options options = serviceClient.getOptions();

        EndpointReference targetEPR = new EndpointReference(
                "http://127.0.0.1:8080/services/mockUserServiceSoap11Binding");// 指定调用WebService的URL
        options.setTo(targetEPR);

        Object[] opAddEntryArgs = new Object[]{new Integer(1)};// 指定getGreeting方法的参数值

        Class[] classes = new Class[]{String.class};// 指定sayHello方法返回值的数据类型的Class对象
        QName opAddEntry = new QName("http://critc.com.cn",
                "sayHello");// 指定要调用的getGreeting方法及WSDL文件的命名空间
        Object[] objects = serviceClient.invokeBlocking(opAddEntry,
                opAddEntryArgs, classes);// RPCServiceClient类的invokeBlocking方法调用了WebService中的方法。invokeBlocking方法有三个参数，其中第一个参数的类型是QName对象，表示要调用的方法名；第二个参数表示要调用的WebService方法的参数值，参数类型为Object[]；第三个参数表示WebService方法的返回值类型的Class对象，参数类型为Class[]。当方法没有参数时，invokeBlocking方法的第二个参数值不能是null，而要使用new Object[]{}。
        System.out.println(objects[0]);

    }

}
