**Datadog with Spring Boot**:

```markdown
# Integrating Datadog with Spring Boot

## 🔧 Step-by-Step Process

### 1. Set Up Datadog
- Sign up for a Datadog account.
- Retrieve your **API key** and **application key** from the Datadog dashboard.

---

### 2. Add Dependencies
Spring Boot uses **Micrometer** for metrics. Add the Datadog registry dependency:

```xml
<dependency>
  <groupId>io.micrometer</groupId>
  <artifactId>micrometer-registry-datadog</artifactId>
</dependency>
```

Also add **Spring Boot Actuator**:

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

---

### 3. Configure Application Properties
In `application.yml`:

```yaml
management:
  metrics:
    export:
      datadog:
        enabled: true
        api-key: YOUR_DATADOG_API_KEY
        application-key: YOUR_DATADOG_APP_KEY
        uri: YOUR_DATADOG_URI
        step: 30s
      metrics:
       tags:
        application: my-app 
logging:
  level:
    root: DEBUG
```

- `step`: interval for pushing metrics.
- Add tags for environment/service if needed.

---

### 4. Install Datadog Agent
- Install the **Datadog Agent** on your host or container.
- Configure the agent to accept metrics and traces.
- For Docker/Kubernetes, run the agent as a sidecar or separate container.

---

### 5. Enable APM (Tracing)
Add the Datadog tracer dependency:

```xml
<dependency>
  <groupId>com.datadoghq</groupId>
  <artifactId>dd-trace-api</artifactId>
  <version>latest</version>
</dependency>
```

Run your Spring Boot app with the agent:

```bash
java -javaagent:/path/to/dd-java-agent.jar \
     -Ddd.service=spring-boot-app \
     -Ddd.env=dev \
     -Ddd.version=1.0 \
     -jar target/app.jar
```

---

### 6. Verify in Datadog
- Use **Metrics Explorer** to view Spring Boot metrics (CPU, memory, request counts).
- Check **APM dashboards** for traces, latency, and errors.
- Add custom metrics via Micrometer’s `MeterRegistry` if needed.

---

## Benefits
- Unified monitoring: metrics, logs, and traces in one place.
- Performance insights: latency, DB queries, external calls.
- Alerting: thresholds for errors, response times, or resource usage.

---

## Example Custom Metric
```java
@Autowired
MeterRegistry registry;

public void recordCustomMetric() {
    registry.counter("custom.requests", "endpoint", "/api/test").increment();
}
```

This will send a custom counter metric to Datadog.
```

---
