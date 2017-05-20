package com.critc.mongo;

import com.critc.mongo.model.Article;
import com.critc.mongo.repository.ArticleRepository;
import com.critc.mongo.util.MongoAutoidUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by 孔垂云 on 2017/5/20.
 * 测试自增id
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-mongo.xml"})
public class TestAutoid {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MongoAutoidUtil mongoAutoidUtil;

    @Test
    public void add() {
        for (int i = 0; i < 10; i++) {  //增加一条记录
            Article article = new Article();
            article.setId(mongoAutoidUtil.getNextSequence("seq_article"));
            article.setTitle("MongoTemplate的基本使用");
            article.setAuthor("kcy");
            article.setUrl("http://jianshu.com/");
            article.setTags(Arrays.asList("java", "mongodb", "spring"));
            article.setVisitCount(0L);
            article.setAddTime(new Date());
            mongoTemplate.save(article);

        }

        Iterable<Article> articles = articleRepository.findAll();
        articles.forEach(article2 -> {
            System.out.println(article2.toString());
        });
    }
}
