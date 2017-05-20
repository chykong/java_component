package com.critc.mongo;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

/**
 * Created by 孔垂云 on 2017/5/20.
 * 连接数据库
 */
public class MongoConnect {

    /**
     * 建立mongodb连接
     *
     * @return
     */
    public MongoClient getConnection() {
        MongoClient mongoClient = null;
        try {
            //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
            //ServerAddress()两个参数分别为 服务器地址 和 端口
            ServerAddress serverAddress = new ServerAddress("localhost", 27017);
           /* List<ServerAddress> addrs = new ArrayList<ServerAddress>();
            addrs.add(serverAddress);//如果是集群，需要用到地址列表*/
            mongoClient = new MongoClient(serverAddress);
            /*
            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
            MongoCredential credential = MongoCredential.createScramSha1Credential("username", "databaseName", "password".toCharArray());
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
            credentials.add(credential);

            //通过连接认证获取MongoDB连接
            mongoClient = new MongoClient(addrs, credentials);
            */
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return mongoClient;
    }

    /**
     * 关闭连接
     *
     * @param mongoClient
     */
    public void closeConnection(MongoClient mongoClient) {
        mongoClient.close();
    }

    public static void main(String[] args) {
        MongoConnect mongoConnect = new MongoConnect();
        MongoClient mongoClient = mongoConnect.getConnection();
        System.out.println(mongoClient);
        mongoConnect.closeConnection(mongoClient);
    }

}
