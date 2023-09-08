package com.heima.wemedia;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.UUID;

/**
 * TODO
 *
 * @Date 2023/9/8 8:53
 * @Author pepedd864
 */
@SpringBootTest
public class RedisTest {
  @Autowired
  private RedisTemplate redisTemplate;

  @Test
  public void test() {
    redisTemplate.opsForValue().set("name", "pepedd864");
    redisTemplate.opsForValue().set("uuid", UUID.randomUUID().toString());
    System.out.println(redisTemplate.opsForValue().get("name"));
    System.out.println(redisTemplate.opsForValue().get("uuid"));
  }
}
