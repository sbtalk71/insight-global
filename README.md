## 1. Spring DI Assignment: https://classroom.github.com/a/NTAlzxcg

```sh
resilience4j.circuitbreaker:
 instances:
    hr-service-cb:
     registerHealthIndicator: true
     slidingWindowSize: 10
     permittedNumberOfCallsInHalfOpenState: 3
     slidingWindowType: COUNT_BASED
     minimumNumberOfCalls: 5
     waitDurationInOpenState: 5s
     failureRateThreshold: 33.3
     automaticTransitionFromOpenToHalfOpenEnabled: true
```
