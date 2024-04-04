package com.jiuzhang.seckill.mq;

import java.util.Date;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MQTest {
  @Resource
  private RocketMQService service;

  @Test
  public void sendMQTest() throws Exception{
    service.sendMessage("test-jiuzhang","Hello world!" + new Date().toString());
  }
}
