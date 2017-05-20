package com.critc.mongo.model;

import org.springframework.data.annotation.Id;

/**
 * Created by 孔垂云 on 2017/5/20.
 * Mongo序列，模仿oracle的序列
 */
public class MongoSequence {
    @Id
    private String id;
    private int seq;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
