# spring-cloud
spring cloud全家桶，各个组件整合使用

## spring eureka 注册中心(基础)

    我们使用微服务，微服务的本质还是各种API接口的调用，那么我们怎么产生这些接口、产生了这些接口之后如何进行调用那？如何进行管理哪？

    答案就是Spring Cloud Eureka，我们可以将自己定义的API 接口注册到Spring Cloud Eureka上，Eureka负责服务的注册与发现，如果学习过Zookeeper的话，
    就可以很好的理解，Eureka的角色和 Zookeeper的角色差不多，都是服务的注册和发现，构成Eureka体系的包括：服务注册中心、服务提供者、服务消费者。

![注册中心](https://img-blog.csdn.net/20170901162900847?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQveGxnZW4xNTczODc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

上图中描述了（图片来源于网络）：

    1、两台Eureka服务注册中心构成的服务注册中心的主从复制集群； 
    2、服务提供者向注册中心进行注册、续约、下线服务等； 
    3、服务消费者向Eureka注册中心拉取服务列表并维护在本地（这也是客户端发现模式的机制体现！）； 
    4、服务消费者根据从Eureka服务注册中心获取的服务列表选取一个服务提供者进行消费服务。

### 参考网站
 + 相关学习博客，请查看[相关学习文档](https://www.cnblogs.com/cralor/p/9223994.html "spring boot 2.0.3+spring cloud （Finchley）1、搭建服务注册和发现组件Eureka 以及构建高可用Eureka Server集群")
 + 如有任何问题欢迎联系作者：tikie
 
        qq:290315636
    
 
### 项目环境
 - Eclipse：Oxygen.3a Release (4.7.3a)
 
        彩色日志插件：http://www.mihai-nita.net/eclipse
 - jdk:1.8+
 - spring boot: 2.0.3.RELEASE
 - spring-cloud: Finchley.RELEASE

### 初始化操作
 1. NEW
 2. New Spring Starter Project
 3. Cloud Discovery
 4. Eureka Service
 5. 配置host
 
        127.0.0.1           peer1
        127.0.0.1           peer2
 
 + 运行主注册中心：TikieEurekaServerApplication.java
    
        Run As
        Run Configurations...
        Spring Boot > Profile > *peer1* > Run
   
 + 运行副注册中心：TikieEurekaServerApplication.java
    
        Run As
        Run Configurations...
        Spring Boot > Profile > *peer2* > Run
 + 或命令行启动方式：
 
        java -jar tikie-eureka-registry-center-0.0.1-SNAPSHOT.jar.jar --spring.profiles.active=peer1
        java -jar tikie-eureka-registry-center-0.0.1-SNAPSHOT.jar.jar --spring.profiles.active=peer2
 + 注册中心页面主节点：http://peer1:8761
 + 注册中心页面副节点：http://peer2:8761/
 
 + *本项目的默认只提供dev分支的更新权限*
 
 + 设置默认push/pull行为(push当前分支到远程同名分支，如果远程同名分支不存在则自动创建同名分支)
    
       git config push.default "current"
       git config pull.default "current"
       
       #在对应的分支上执行：如dev分支
       git branch --set-upstream-to=origin/dev
 + 注 
 
       主、副注册中心启动时会相互寻找，会报错，都起来后不会报错
 
### 其他相关项目
    1. eureka注册中心 > https://github.com/290315636/tikie-eureka-registry-center
    2. eureka服务提供者(可以有多个实例) > https://github.com/290315636/tikie-eureka-provider
    3. eureka服务消费者 > https://github.com/290315636/tikie-eureka-ribbon-consumer
    4. feign 服务消费者 > https://github.com/290315636/tikie-eureka-feign-consumer
    5. monitor断路器监控器 > https://github.com/290315636/tikie-eureka-monitor-client
    6. zuul路由（断路、过滤）控制器 > https://github.com/290315636/tikie-eureka-zuul
    7. config-server配置中心服务  > https://github.com/290315636/tikie-eureka-config-server
    8. config-client配置中心用户 > https://github.com/290315636/tikie-eureka-config-client
    9. bus
    注. 3、4可以选中其一,优先使用feign;5可以不用启动（使用时启动）
### 历史更新

    1.0.1 更新说明文档
    1.0.0 初始化注册中心及配置

