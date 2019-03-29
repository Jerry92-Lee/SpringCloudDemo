package com.jerry.test.service;

import com.jerry.test.service.entity.User;
import com.mongodb.client.result.DeleteResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * @author Jerry
 * @version 2019-03-18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NoSqlTestApplication {

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 对redis进行查询、删除、新增
     */
//    @Test
    public void optRedis() {
        String key = "r1";
        if (redisCacheTemplate.hasKey(key)) {
            Map<String, Object> map = (Map<String, Object>) redisCacheTemplate.opsForValue().get(key);
            map.forEach((k, v) -> {
                System.out.println("key=" + k + ",value=" + v);
            });

            redisCacheTemplate.delete(key);
            System.out.println("key=" + key + " is exist ... [Delete]");
        }

        User u1 = new User();
        u1.setId(1);
        u1.setName("jerry");
        u1.setAge(26);
        u1.setPassword("Aa123456");
        redisCacheTemplate.opsForValue().set(key, u1);
    }

    @Test
    public void optMongoDB() {
        String colName = "col1";

        User u1 = new User();
        u1.setId(6);
        u1.setName("kimmy");
        u1.setAge(10);
        u1.setPassword("lin");
        u1.setFriend(new User(4, 38, "jordan", "michael"));

        if (mongoTemplate.collectionExists(colName)) {
            // select * from col1 where age >= 18 order by age asc

            Query query = new Query();

            // sort：排序 order by age.asc
            query.with(new Sort(Sort.Direction.ASC, "age"));

            // where age >= 18
            query.addCriteria(Criteria.where("age").gte(20));

            List<User> l1 = mongoTemplate.find(query, User.class, colName);
            l1.forEach(user -> {
                System.out.println("1=" + user.toString());
            });

            DeleteResult result = mongoTemplate.remove(u1, colName);
            System.out.println(colName + " is exists ... [DELETE] " + result.toString());
        }

        mongoTemplate.insert(u1, colName);
    }

    @Test
    public void aggregateMongoDB() {
        List<AggregationOperation> queryList = new ArrayList<>();

        // match：匹配，age > 18
        queryList.add(Aggregation.match(Criteria.where("age").gt(10)));

        // group：分组统计，根据age字段分组
        queryList.add(Aggregation.group("age").count().as("count"));

        // sort：排序，根据count字段，降序
        queryList.add(Aggregation.sort(new Sort(Sort.Direction.DESC, "count")));

        // limit：分页，支取一条记录
        queryList.add(Aggregation.limit(1));

        AggregationResults<User> results = mongoTemplate.aggregate(Aggregation.newAggregation(queryList), "col1", User.class);
        System.out.println(results.getRawResults().toJson());
    }
}
