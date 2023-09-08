package com.heima.wemedia.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * TODO
 *
 * @Date 2023/9/8 8:52
 * @Author pepedd864
 */
@Configuration
@Slf4j
public class RedisConfig {
  @Bean
  public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    log.info("redisTemplate初始化");
    RedisTemplate redisTemplate = new RedisTemplate();
    // 设置连接工厂
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    // 设置key的序列化器
    redisTemplate.setKeySerializer(redisTemplate.getStringSerializer());
    redisTemplate.setHashKeySerializer(redisTemplate.getStringSerializer());
    // 设置value的序列化器
    redisTemplate.setValueSerializer(redisTemplate.getStringSerializer());
    redisTemplate.setHashValueSerializer(redisTemplate.getStringSerializer());
    return redisTemplate;
  }
}
