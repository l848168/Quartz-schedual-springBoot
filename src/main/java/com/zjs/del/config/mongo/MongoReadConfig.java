package com.zjs.del.config.mongo;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoReadConfig {

    @Value("${spring.data.mongodb.read.host}")
    private String host;

    @Value("${spring.data.mongodb.read.port}")
    private int port;

    @Bean
    public MongoClient mongoClient() {
        MongoClient mongoClient;
        mongoClient = new MongoClient(new ServerAddress(host,port));
        return mongoClient;
    }


}
