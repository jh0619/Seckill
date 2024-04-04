package com.jiuzhang.seckill.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisServiceTest {

  @Resource
  private RedisService service;

  @Test
  void setValue() {
    String value = service.setValue("test:1", 100L).getValue("test:1");
    assertEquals(new Long(value), 100L);
  }

  @Test
  void getValue() {
    String value = service.getValue("test:1");
    assertEquals(new Long(value), 100L);
  }

  @Test
  void stockDeductValidation() {
    boolean result = service.stockDeductValidation("test:1");
    assertTrue(result);
    String value = service.getValue("test:1");
    assertEquals(new Long(value), 99L);
  }
}