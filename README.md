# micro-stage

registry
   - netflix-eureka

config
   - apollo
   - spring-cloud-config
 
gateway
   - spring-cloud-gateway
   - netflix-zuul

service
   - service-user 
   - service-goods (@Deprecate)

oauth
   - oauth-server(github)

cache
   - cache-redis
   

弃用config模块，registry & gateway & service 均使用apollo作为配置中心（1.5.0）
apollo部署说明：config/config-apollo/README

2019-12-27
    加入apollo更新配置后通知到各个应用 

2019-12-30
    添加gateway的限流,采用默认提供的令牌桶算法
    
2019-12-31
    集成认证授权

2020-1-2
    集成open-feign到用户服务 done
    需要自定义feign配置

2020-1-3
    集成hystrix in feign
    
2020-1-7
    准备集成oauth-server，支持授权码模式、简化模式、密码模式和服务器模式

2020-1-9
    将github作为oauth-server，已获取到授权码及token，下一步缓存token以及验证OAutherFilter
    
2020-2-4 进行中...
    开发时间轮实现延时任务
    
springcloud脚手架，持续迭代完善中
