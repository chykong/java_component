package com.critc.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

/**
 * Created by 孔垂云 on 2017/5/20.
 */
@Document(collection = "article_info")
public class Article {
    @Id
    private long id;//id
    @Field("title")
    private String title;//标题
    @Field("url")
    private String url;//链接
    @Field("author")
    private String author;//作者
    @Field("tags")
    private List<String> tags;//tag 标签
    @Field("visit_count")
    private Long visitCount;//访问次数
    @Field("add_time")
    private Date addTime;//添加时间


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Long getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Long visitCount) {
        this.visitCount = visitCount;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", author='" + author + '\'' +
                ", tags=" + tags +
                ", visitCount=" + visitCount +
                ", addTime=" + addTime +
                '}';
    }
}
