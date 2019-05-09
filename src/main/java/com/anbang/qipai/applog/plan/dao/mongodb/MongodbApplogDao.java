package com.anbang.qipai.applog.plan.dao.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.anbang.qipai.applog.plan.bean.Applog;
import com.anbang.qipai.applog.plan.dao.ApplogDao;

@Component
public class MongodbApplogDao implements ApplogDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void save(Applog log) {
		mongoTemplate.insert(log);
	}

	@Override
	public void removeByTime(long deadTime) {
		Query query = new Query();
		query.addCriteria(Criteria.where("createTime").lt(deadTime));
		mongoTemplate.remove(query, Applog.class);
	}

}
