# spring-cloud
spring cloud全家桶，各个组件整合使用

## spring eureka 注册中心(基础)

### 参考网站
 + 相关学习博客，请查看[相关学习文档](https://www.cnblogs.com/cralor/p/9223994.html "spring boot 2.0.3+spring cloud （Finchley）1、搭建服务注册和发现组件Eureka 以及构建高可用Eureka Server集群")
 + 如有任何问题欢迎联系作者：tikie
 
        qq:290315636
    
 
### 项目环境
 - Eclipse：Oxygen.3a Release (4.7.3a)
 
        彩色日志插件：http://www.mihai-nita.net/eclipse
 
 - jdk:1.8+


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
 
        java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
        java -jar eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2
 + 注册中心页面主节点：http://peer1:8761/tikie-eureka-registry-center-0.0.1-SNAPSHOTtikie-eureka-registry-center-0.0.1-SNAPSHOT
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

    1. eureka服务提供者(可以有多个实例) > https://github.com/290315636/tikie-eureka-provider
 
### 历史更新

    1.0.1 更新说明文档
    1.0.0 初始化注册中心及配置

