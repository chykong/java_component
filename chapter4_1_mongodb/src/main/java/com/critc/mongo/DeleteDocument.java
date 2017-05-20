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
public class DeleteDocument {

    public static void main(String[] args) {

        MongoConnect mongoConnect = new MongoConnect();
        MongoClient mongoClient = mongoConnect.getConnection();//建立mongb的客户端连接
        MongoCollection<Document> mongoCollection = mongoClient.getDatabase("test").getCollection("collectionTest");//如果不存在会创建

        //删除符合条件的第一个文档
        mongoCollection.deleteOne(Filters.eq("likes", 200));
        //删除所有符合条件的文档
        mongoCollection.deleteMany (Filters.eq("likes", 200));
        //检索查看结果
        FindIterable<Document> findIterable = mongoCollection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while(mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }
    }
}
