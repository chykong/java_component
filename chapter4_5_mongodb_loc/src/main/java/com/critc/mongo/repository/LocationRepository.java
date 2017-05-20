package com.critc.mongo.repository;

import com.critc.mongo.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 孔垂云 on 2017/5/21.
 */

@Repository
public class LocationRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 按圆形查找
     *
     * @param point
     * @param maxDistance
     * @return
     */
    public List<Location> findCircleNear(Point point, double maxDistance) {
        Query query = new Query(Criteria.where("position").near(point).maxDistance(maxDistance));
        return mongoTemplate.find(query, Location.class);
    }

    /**
     * 按方形查找
     *
     * @param lowerLeft
     * @param upperRight
     * @return
     */
    public List<Location> findBoxWithin(Point lowerLeft, Point upperRight) {
        Query query = new Query(Criteria.where("position").within(new Box(lowerLeft, upperRight)));
        return mongoTemplate.find(query, Location.class);
    }
}
