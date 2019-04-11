### 一、运行工具与环境
运行环境：JDK 8，Maven 3.6

技术栈：SpringBoot 2.0.6.RELEASE、SpringCloud Finchley.RELEASE

用途：Spring Cloud 的一个入门程序，包含服务注册与发现 Eureka，服务提供与调用 Ribbon，Feign，断路器 Hystrix，配置中心 Config，网关  Zuul。


### 二、运行说明
#### 2.1注册中心
运行 EurekaServerApplication 服务，会启动注册中心，配置的端口为16000，可以通过 http://localhost:16000 来观察启动注册的服务。

#### 2.2注册中心客户端
注册中心客户端包括服务提供者及服务消费者，服务提供者运行 EurekaClientProviderApplication 启动，占用16002端口；服务消费者运行 EurekaClientConsumerApplication 启动，占用16003端口；

调用 http://localhost:16002/hello/info?name=Tom 会直接访问服务提供端；当然服务消费端通过 Feign 也可以访问服务提供端，具体访问 http://localhost:16003/hello/info?name=Tom；

服务消费端增加了熔断机制，如果服务提供端宕机，消费端在访问时会执行熔断流程。

#### 2.3配置中心服务端
配置中心服务端也使用了注册中心实现服务的高可靠，运行 ConfigServerApplication 会启动配置中心服务端服务，占用16004端口，同时会从配置的 git 仓库 https://github.com/uniwjj/eureka-demo 的 config-repo 文件夹拉取配置，配置中心客户端可以从配置中心服务端拉取所有配置信息。

#### 2.4配置中心客户端
配置中心客户端也使用了注册中心实现服务的高可靠，运行 ConfigClientApplication 会启动配置中心客户端服务，占用16005端口，同时会从配置中心服务端拉取配置对本地的配置进行覆盖，访问 http://localhost:16005/hello/info 会返回相应结果。

#### 2.5网关
网关服务用于路由及过滤器功能，启动 ApiGatewayApplication 服务，占用16006端口，会自动发现注册中心上的服务，比如上述的 EurekaClientProviderApplication 和 EurekaClientConsumerApplication，Zuul 会自动创建下面两个路由规则：
- 转发到eureka-client-producer服务的请求规则为：/eureka-client-producer/**
- 转发到eureka-client-consumer服务的请求规则为：/eureka-client-consumer/**

调用 http://localhost:16002/eureka-client-consumer/hello/info?name=Tom 会得到相同的访问结果。

当然，网关也增加过滤器功能，在访问时，如果不增加token作为请求参数，会被过滤器拦截，并报401，响应 token is blank。
