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
   

弃用config模块，registry & gateway & service 均使用apollo作为配置中心（1.5.0）
apollo部署说明：config/config-apollo/README

2019-12-27
    加入apollo更新配置后通知到各个应用 

2019-12-30（进行中）
    添加gateway的限流

    
springcloud脚手架，持续迭代完善中
