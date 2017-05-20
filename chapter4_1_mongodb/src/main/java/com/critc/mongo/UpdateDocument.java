package com.critc.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 * Created by 孔垂云 on 2017/5/20.
 */
public class UpdateDocument {
    public static void main(String[] args) {

        MongoConnect mongoConnect = new MongoConnect();
        MongoClient mongoClient = mongoConnect.getConnection();//建立mongb的客户端连接
        MongoCollection<Document> mongoCollection = mongoClient.getDatabase("test").getCollection("collectionTest");//如果不存在会创建

        //更新文档   将文档中likes=100的文档修改为likes=200
        mongoCollection.updateMany(Filters.eq("likes", 100), new Document("$set", new Document("likes", 200)));
        //检索查看结果
        FindIterable<Document> findIterable = mongoCollection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()) {
            System.out.println(mongoCursor.next());
        }
    }
}
