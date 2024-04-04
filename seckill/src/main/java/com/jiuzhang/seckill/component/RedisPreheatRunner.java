package com.jiuzhang.seckill.component;

import com.jiuzhang.seckill.db.dao.SeckillActivityDao;
import com.jiuzhang.seckill.db.po.SeckillActivity;
import com.jiuzhang.seckill.service.RedisService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RedisPreheatRunner implements ApplicationRunner {

  @Resource
  private SeckillActivityDao seckillActivityDao;

  @Resource
  private RedisService redisService;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    List<SeckillActivity> seckillActivities = seckillActivityDao.querySeckillActivitysByStatus(1);
    for (SeckillActivity seckillActivity : seckillActivities){
      redisService.setValue("stock:" + seckillActivity.getId(),
          (long) seckillActivity.getAvailableStock());
    }
  }
}
