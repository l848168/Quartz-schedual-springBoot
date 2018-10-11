package com.zjs.del.service.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.zjs.del.mapper.HistAddrMapper;
import com.zjs.del.model.entity.HistAddrProvice;
import com.zjs.del.model.entity.HistAddrWritePro;
import com.zjs.del.service.MongoService;
import com.zjs.del.utils.DateUtil;
import com.zjs.del.utils.Md5Util;
import com.zjs.del.utils.PubUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
@Service
@Slf4j
public class MongoServiceImpl implements MongoService {


    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MongoClient mongoClient;
    @Resource
    private HistAddrMapper histAddrMapper;

    @Value("${spring.start.time}")
    private String time;

    private Long startTime = 0l;

    private static final Long ONE_DAY = 1000 * 60 * 60 * 24l;

    //计数
    private Integer count = 0;

    @Override
    public void syncData() {
        try {
            if (startTime == 0l) {
                startTime = strTransformationLong(time, 1);
            }
            Long endTime = strTransformationLong("", 2);
            String databaseName = "";
            //只获取分单准确的地址数据
            Bson bson = BasicDBObject.parse("{isUnified:0}");
            Update update = new Update().inc("frequency", 1);
            while (startTime <= endTime) {
                databaseName = DateUtil.getYMD(startTime);
                log.info("开始读取：{}日的数据===============================", databaseName);
                Long start = System.currentTimeMillis();
                MongoDatabase database = mongoClient.getDatabase(databaseName);
                MongoCursor<String> collectionNames = database.listCollectionNames().iterator();
                while (collectionNames.hasNext()) {
                    String collectionName = collectionNames.next();
                    log.info("开始读取：{}日，{}的数据===============================",databaseName, collectionName);
                    MongoCollection<Document> collection = database.getCollection(collectionName);
                    MongoCursor<Document> documents = collection.find(bson).iterator();
                    while (documents.hasNext()) {
                        Document document = documents.next();
                        String address = (String) document.get("address");
                        String tableName = HistAddrProvice.getTabName(collectionName);
                        HistAddrWritePro histAddr = new HistAddrWritePro();
                        try {
                            histAddr = histAddrMapper.findHistAddrByAddress(tableName, address);
                            if (PubUtils.isNull(histAddr)) {
                                continue;
                            }
                        } catch (Exception e) {
                            log.error("查询oracle历史地址库出现异常：{}，{}日，{}的数据，地址为：{}"
                                    , ExceptionUtils.getStackTrace(e), databaseName, collectionName, address);
                        }
                        histAddr.setId(Md5Util.getMD5(address));
                        histAddr.setOrderId("MigrationData");
                        // 使用insert方法插入，如果该记录以及存在，通过捕获相应异常进行次数加1操作
                        try {
                            mongoTemplate.insert(histAddr);
                            count++;
                        } catch (DuplicateKeyException e) {
                            Query query = new Query().addCriteria(Criteria.where("id").is(histAddr.getId()));
                            mongoTemplate.findAndModify(query, update, HistAddrWritePro.class);
                        } catch (Exception e) {
                            log.error("mongo插入过程中，出现其他异常：{}，{}日，{}的数据，地址为：{}"
                                    , ExceptionUtils.getStackTrace(e), databaseName, collectionName, address);
                        }
                    }
                }
                Long end = System.currentTimeMillis();
                log.info("{}日数据处理完毕，耗时：{}", databaseName, end - start);
                startTime += ONE_DAY;
            }
        } catch (Exception e) {
            log.error("出现异常：{}", ExceptionUtils.getStackTrace(e));
        }
        if(count>0){
            log.warn("截止 {} 日，本次共存入了 {} 数据", DateUtil.getYMD(startTime), count);
        }
        count = 0;
    }

    private Long strTransformationLong(String str, int diff) {
        Calendar date = null;
        try {
            date = Calendar.getInstance();
            if (diff == 1) {
                date.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(str));
            } else if (diff == 2) {
                date.setTime(new Date());
            }
            date.add(Calendar.DATE, -1);
            date.set(Calendar.HOUR_OF_DAY, 0);
            date.set(Calendar.MINUTE, 0);
            date.set(Calendar.SECOND, 0);
        } catch (ParseException e) {
            log.error("日期字符串转成时间戳出现异常");
        }
        return date.getTimeInMillis();
    }
}
