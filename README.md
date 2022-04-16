Flow followed from this astounding YouTube tutorial: https://www.youtube.com/watch?v=BnknNTN8icw
Resilience4J configuration examples: https://github.com/resilience4j/resilience4j-spring-boot2-demo/blob/master/src/main/resources/application.yml
Resilience4J docs: https://resilience4j.readme.io/docs/getting-started-3

Important components:

1) Service registry (Spring Eureka Server used together with Spring Eureka Client)
2) API Gateway (used together with fallback functions from Spring Cloud that are triggered in case a microservice is
   down)
3) Hystrix + Actuator (used to monitor the requests)
4) Hystrix Dashboard (used to display the history of the requests on each endpoint)
5) Config Server (a server used specifically for serving a config file stored within a repository -> one common config
   for all microservices)  !! NOT IMPLEMENTED HERE !!
6) Zipkin Logs Tracer (is able to track the flows of the requests together with their logs and display them nicely)  !!
   NOT IMPLEMENTED HERE !!

Relevant URLs:

1) http://localhost:8761/ (Eureka service registry)
2) http://localhost:9295/hystrix/monitor (Hystrix dashboard)
3) http://localhost:9191/actuator/hystrix.stream (Actuator stream of data packets)

### Observation: at the moment the actuator is not updating properly and the config server + zipkin logs have not been implemented

### The fallback methods of the gateway are ONLY triggering when the services are OFFLINE
