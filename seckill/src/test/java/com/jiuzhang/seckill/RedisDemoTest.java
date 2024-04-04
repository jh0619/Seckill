package com.jiuzhang.seckill;

import com.jiuzhang.seckill.service.RedisService;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisDemoTest {

  @Resource
  private RedisService redisService;

  @Test
  public void stockTest(){
    String value = redisService.setValue("stock:19", 10L).getValue("stock:19");
    System.out.println(value);
  }
}
