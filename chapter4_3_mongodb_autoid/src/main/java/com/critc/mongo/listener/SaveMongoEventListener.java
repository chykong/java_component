package com.critc.mongo.listener;

import com.critc.mongo.model.GeneratedValue;
import com.critc.mongo.model.SequenceId;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.util.ReflectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;

/**
 * 实现自增的监听器，原理就是从Collection sequence中获取
 */
public class SaveMongoEventListener extends AbstractMongoEventListener<Object> {
	@Resource
	private MongoTemplate mongoTemplate;

	public void onBeforeConvert(final Object source) {
		if(source != null) {
			ReflectionUtils.doWithFields(source.getClass(), new ReflectionUtils.FieldCallback() {
				public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
					ReflectionUtils.makeAccessible(field);
					if (field.isAnnotationPresent(GeneratedValue.class)) {
						//设置自增ID
						field.set(source, getNextId(source.getClass().getSimpleName()));
					}
				}
			});
		}
	}
	
	/**
	 * 获取下一个自增ID
	 * @author 孔垂云
	 * @param collName  集合名
	 * @return
	 */
	private Long getNextId(String collName) {
	    Query query = new Query(Criteria.where("collName").is(collName));
	    Update update = new Update();
	    update.inc("seqId", 1);
	    FindAndModifyOptions options = new FindAndModifyOptions();
	    options.upsert(true);
	    options.returnNew(true);
	    SequenceId seqId = mongoTemplate.findAndModify(query, update, options, SequenceId.class);
	    return seqId.getSeqId();
	}
}
