# micro-stage

registry
   - netflix-eureka

config
   - spring-cloud-config
 
gateway
   - spring-cloud-gateway
   - netflix-zuul

service
   - service-user 
   - service-goods (@Deprecate)
   

弃用config模块，registry & gateway & service 均使用apollo作为配置中心（1.5.0）
apollo部署说明：config/config-apollo/README

2019-12-27
    加入apollo更新配置后通知到各个应用 

2019-12-30
    添加gateway的限流,采用默认提供的令牌桶算法
    
2019-12-31 进行中...
    集成认证授权

2020-1-2
    集成open-feign到用户服务 done
    需要自定义feign配置

2020-1-3 进行中
    集成hystrix in feign
    
2020-1-7 进行中
    准备集成oauth-server，支持授权码模式、简化模式、密码模式和服务器模式
    
springcloud脚手架，持续迭代完善中
