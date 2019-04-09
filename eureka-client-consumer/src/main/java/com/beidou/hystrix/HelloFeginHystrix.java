package com.beidou.hystrix;

import com.beidou.fegin.HelloFeign;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HelloFegin接口的Hystrix实现
 *
 * @author wangjinjie
 * @create 2019-04-08 22:46
 */
@Component
public class HelloFeginHystrix implements HelloFeign {

  @Override
  public String hello(@RequestParam String name) {
    return "Hello " + name + ", from hystrix.";
  }
}
