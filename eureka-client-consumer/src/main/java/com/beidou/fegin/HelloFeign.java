package com.beidou.fegin;

import com.beidou.hystrix.HelloFeginHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Hello外键调用
 *
 * @author wangjinjie
 * @create 2019-04-08 22:02
 */
@FeignClient(name = "eureka-client-provider", fallback = HelloFeginHystrix.class)
public interface HelloFeign {

  @RequestMapping(value = "/hello/info", method = RequestMethod.GET)
  String hello(@RequestParam(value = "name") String name);
}