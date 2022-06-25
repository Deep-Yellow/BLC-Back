# README

## 技术栈

- Java - Spring Boot, Spring Cloud
- MyBatis-Plus
- Mysql
- Docker

## 项目结构
### 治理框架

Eureka Server --- 服务发现
Gateway --- 网关

### 微服务

blc-activity --- 对应”最新动态“
blc-team ---  对应 “团队成员” 和 ”科研成果“中的”发表文章“
blc-projects --- 对应”项目展示“
blc-coin --- 对应“区块链知识图谱”

## 部署方式

部署方式为打包后手动部署，下面是示例的Docker指令

**需求：把宿主机的/spring挂载到容器，容器创建后自动运行程序**

```bash
#Nginx 前端页面
docker run -d --name=nginx_01 -p 22525:80 -v /nginx/resources:/usr/share/nginx/html nginx

# Eureka
# 可能会出现执行后马上挂掉的情况 检查jar包是否已经给了执行权限
docker run -itd --name EurekaServer --restart=always -p 8761:8761 -v /root/Spring/EurekaServer:/Spring adoptopenjdk/openjdk8 java -jar /Spring/EurekaServer-0.0.1-SNAPSHOT.jar  --spring.profiles.active=prod

# Coin
# 特殊需求，需要挂载csv文件夹
docker run -itd --name coin --restart=always -p 8089:8089 -v /root/blcCoin:/root/blcCoin -v /root/Spring/Coin:/Spring adoptopenjdk/openjdk8 java -jar /Spring/blc-coin-0.0.1-SNAPSHOT.jar  --spring.profiles.active=prod
# Gateway
docker run -itd --name gateway --restart=always -p 9999:9999 -v /root/Spring/Gateway:/Spring adoptopenjdk/openjdk8 java -jar /Spring/Gateway-0.0.1-SNAPSHOT.jar  --spring.profiles.active=prod
# Team 网站team模块
docker run -itd --name team --restart=always -p 8081:8081 -v /root/Spring/blcTeam:/Spring adoptopenjdk/openjdk8 java -jar /Spring/BLC-Team-0.0.1-SNAPSHOT.jar  --spring.profiles.active=prod
# Project 网站project模块
docker run -itd --name projects --restart=always -p 8082:8082 -v /root/Spring/blcProject:/Spring adoptopenjdk/openjdk8 java -jar /Spring/blc-projects-0.0.1-SNAPSHOT.jar  --spring.profiles.active=prod
# Activity 网站activity模块
docker run -itd --name activity --restart=always -p 8084:8084 -v /root/Spring/blcActivity:/Spring adoptopenjdk/openjdk8 java -jar /Spring/blc-activity-0.0.1-SNAPSHOT.jar  --spring.profiles.active=prod
```

**设置自动重启：**--restart=always