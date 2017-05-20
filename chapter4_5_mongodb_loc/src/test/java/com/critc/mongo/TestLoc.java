package com.critc.mongo;

import com.critc.mongo.model.Location;
import com.critc.mongo.repository.LocationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by 孔垂云 on 2017/5/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-mongo.xml"})
public class TestLoc {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void init() {
        // 等同db.location.ensureIndex( {position: "2d"} )
        mongoTemplate.indexOps(Location.class).ensureIndex(new GeospatialIndex("position"));
        // 初始化数据
        mongoTemplate.save(new Location("天安门", 116.4041602659, 39.9096215780));
        mongoTemplate.save(new Location("东单", 116.4244857287, 39.9144951360));
        mongoTemplate.save(new Location("王府井", 116.4177807251, 39.9175129885));
        mongoTemplate.save(new Location("西单", 116.3834863095, 39.9133467579));
        mongoTemplate.save(new Location("复兴门", 116.3631701881, 39.9129554253));
        mongoTemplate.save(new Location("复兴门", 116.3631701881, 39.9129554253));
        mongoTemplate.save(new Location("西四", 116.3799838526, 39.9299098531));
        mongoTemplate.save(new Location("菜市口", 116.3809950293, 39.8952009239));
        mongoTemplate.save(new Location("东四", 116.4239387439, 39.9306126797));

    }

    /**
     * 查找天安门附近3公里的地点
     */
    @Test
    public void findCircleNearTest() {
        List<Location> locations = locationRepository.findCircleNear(new Point(116.4041602659, 39.9096215780), 3 / 111d);
        locations.forEach(location -> {
            System.out.println(location.toString());
        });
    }

    /**
     * 查找左下角是菜市口，右上角是东四，这个方形区域内的所有点
     */
    @Test
    public void findBoxNearTest() {
        Point point1 = new Point(116.3809950293, 39.8952009239);
        Point point2 = new Point(116.4239387439, 39.9306126797);
        List<Location> locations = locationRepository.findBoxWithin(point1, point2);
        locations.forEach(location -> {
            System.out.println(location.toString());
        });
    }
}
