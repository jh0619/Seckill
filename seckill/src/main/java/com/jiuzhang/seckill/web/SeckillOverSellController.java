package com.jiuzhang.seckill.web;

import com.jiuzhang.seckill.service.SeckillActivityService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SeckillOverSellController {

  /*
  @Resource
  private SeckillOverSellService seckillOverSellService;
   */

  @Resource
  private SeckillActivityService seckillActivityService;

  /*
  @ResponseBody
  @RequestMapping("/seckill/{seckillActivityId}")
  public String seckill(@PathVariable long seckillActivityId){
    return seckillOverSellService.processSeckill(seckillActivityId);
  }
   */

  @ResponseBody
  @RequestMapping("/seckill/{seckillActivityId}")
  public String seckillCommodity(@PathVariable long seckillActivityId){
    boolean stockValidateResult = seckillActivityService.seckillStockValidator(seckillActivityId);
    return stockValidateResult ? "恭喜你秒杀成功" : "很遗憾商品已售完";
  }
}
