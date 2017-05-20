package com.critc.mongo;

import com.critc.mongo.vo.ArticleResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

/**
 * Created by 孔垂云 on 2017/5/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-mongo.xml"})
public class TestAggregation {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testAggregation() {
        Aggregation agg = newAggregation(
                group("author").count().as("count").first("author").as("name"),
                project("name", "count"),
                sort(Sort.Direction.DESC, "count"),
                match(Criteria.where("count").gt(0))
        );
        AggregationResults<ArticleResult> results = mongoTemplate.aggregate(agg, "article_info", ArticleResult.class);
        List<ArticleResult> tagCount = results.getMappedResults();
        for (ArticleResult studentResult : tagCount) {
            System.out.println(studentResult.getName() + "\t" + studentResult.getCount());
        }
    }
}
