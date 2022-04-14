Flow followed from this astounding YouTube tutorial: https://www.youtube.com/watch?v=BnknNTN8icw

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

## Observation: at the moment the hystrix dashboard is not working properly and the config server + zipkin logs have not been implemented