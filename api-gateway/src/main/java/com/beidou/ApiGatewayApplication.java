package com.beidou;

import com.beidou.filter.TokenFilter;
import com.netflix.zuul.ZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * API网关启动类
 *
 * @author ginger
 * @create 2019-04-09 14:37
 */
@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayApplication {

  @Bean
  public ZuulFilter tokenFilter() {
    return new TokenFilter();
  }

  public static void main(String[] args) {
    SpringApplication.run(ApiGatewayApplication.class, args);
  }
}
