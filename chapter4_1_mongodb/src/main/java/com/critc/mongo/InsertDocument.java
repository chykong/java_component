package com.critc.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 孔垂云 on 2017/5/20.
 * 插入文档
 */
public class InsertDocument {

    public static void main(String[] args) {
        MongoConnect mongoConnect = new MongoConnect();
        MongoClient mongoClient = mongoConnect.getConnection();//建立mongb的客户端连接
        MongoCollection<Document> mongoCollection = mongoClient.getDatabase("test").getCollection("collectionTest");//如果不存在会创建
        Document document = new Document("title", "MongoDB").
                append("description", "database").
                append("likes", 100).
                append("by", "Fly");
        List<Document> documents = new ArrayList<Document>();
        documents.add(document);
        mongoCollection.insertMany(documents);
        System.out.println("文档插入成功");
    }
}
