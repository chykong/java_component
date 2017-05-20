package com.critc.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by 孔垂云 on 2017/5/20.
 */
public class CreateCollection {

    public static void main(String[] args) {
        MongoConnect mongoConnect = new MongoConnect();
        MongoClient mongoClient = mongoConnect.getConnection();//建立mongb的客户端连接

        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");//连接指定数据库test,如果不存在会创建
        System.out.println("连接数据库成功");
        //创建集合 参数为 “集合名称”
        mongoDatabase.createCollection("collectionTest");//创建集合
        System.out.println("集合创建成功");

        //获取集合 参数为“集合名称”
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("collectionTest");//如果不存在会创建
        System.out.println("成功获取集合");
    }
}
