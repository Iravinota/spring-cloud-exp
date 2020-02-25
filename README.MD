# Spring Cloud简单示例

一个简单的SpringCloud示例。SpringCloud是基于spring-boot实现的、整合了多种开源组件的、对微服务进行支持的框架。

## 1. 启动

- 运行eureka-server/../ErekaServerApplication
  - 浏览器中输入<http://localhost:8761/>，可以看到Eureka的界面
- 运行hello-service/.../中的main程序
  - 在Eureka界面，可以看到hello-service这个服务
  - 浏览器中输入<http://localhost:8763/hi>，可以看到返回信息
- 运行api-gateway/.../中的main程序
  - 在Eureka界面，可以看到ZUUL这个服务。提供路由
  - 浏览器中输入<http://localhost:8769/hello/hi>，可以看到返回信息。这是路由到hello-service进行调用了
- 运行call-service/.../中的main程序
  - 在Eureka界面，可以看到call-service这个服务
  - 浏览器中输入<http://localhost:8764/haha>，可以看到返回信息。这是直接到call-service，并且由call-service直接返回
  - 浏览器中输入<http://localhost:8764/hi>，可以看到返回信息。这是直接到call-service，又进一步调用了hello-service的/hi
  - 浏览器中输入<http://localhost:8764/call/hi>，可以看到返回信息。这是通过ZUUL路由到call-service，又进一步调用了hello-service的/hi

## 2. 各模块作用

- eureka-server: 注册中心
  - @SpringBootApplication
  - @EnableEurekaServer // EurekaServer
- hello-service: 服务提供者
  - @SpringBootApplication
  - @EnableDiscoveryClient
  - @RestController
  - @RequestMapping("/hi")
- api-gateway:   使用Zuul对服务进行路由
  - @SpringBootApplication
  - @EnableDiscoveryClient
  - @EnableZuulProxy
- call-service:  服务使用者，使用Feign调用了hello-service服务；服务提供者，提供了/haha
  - @SpringBootApplication
  - @EnableDiscoveryClient
  - @RestController
  - @EnableFeignClients
  - @RequestMapping("/hi")
  - @RequestMapping("/haha")
  - ================
  - @FeignClient(value = "hello-service")
  - @RequestMapping(value = "/hi", method = RequestMethod.GET)
