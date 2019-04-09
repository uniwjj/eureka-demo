### 一、运行工具与环境
运行环境：JDK 8，Maven 3.6

技术栈：SpringBoot 2.0.6.RELEASE、SpringCloud Finchley.RELEASE

用途：Spring Cloud 的一个入门程序，包含服务注册与发现 Eureka，服务提供与调用 Ribbon，Feign，断路器 Hystrix，配置中心 Config，网关  Zuul。


### 二、运行说明
#### 2.1注册中心
运行 EurekaServerApplication 服务，会启动注册中心，配置的端口为9000，可以通过 http://localhost:9000 来观察启动注册的服务。

#### 2.2注册中心客户端
注册中心客户端包括服务提供者及服务消费者，服务提供者运行 EurekaClientProviderApplication 启动，占用9002端口；服务消费者运行 EurekaClientConsumerApplication 启动，占用9003端口；

调用 http://localhost:9002/hello/info?name=Tom 会直接访问服务提供端；当然服务消费端通过 Feign 也可以访问服务提供端，具体访问 http://localhost:9003/hello/info?name=Tom；

服务消费端增加了熔断机制，如果服务提供端宕机，消费端在访问时会执行熔断流程。

#### 2.3配置中心服务端


#### 2.4配置中心客户端


#### 2.5网关

