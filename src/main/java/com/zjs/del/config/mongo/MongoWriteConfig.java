package com.zjs.del.config.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import javax.annotation.Resource;

@Configuration
public class MongoWriteConfig {


    @Value("${spring.data.mongodb.write.host}")
    private String mongoUri;
    @Value("${spring.data.mongodb.write.name}")
    private String mongodbName;
    @Resource
    private ApplicationContext appContext;

    @Primary
    public MongoClient mongoClient() {
        MongoClient mongoClient;
        MongoClientURI mongoClientURI = new MongoClientURI(mongoUri);
        mongoClient = new MongoClient(mongoClientURI);
        return mongoClient;
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        MongoDbFactory factory = new SimpleMongoDbFactory(mongoClient(),mongodbName);
        MongoMappingContext mongoMappingContext = new MongoMappingContext();
        mongoMappingContext.setApplicationContext(appContext);
        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(factory), mongoMappingContext);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return new MongoTemplate(factory, converter);

    }
}
