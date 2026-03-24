
# SonarQube Quality Gates & JaCoCo with Spring Boot

## 1. What is SonarQube?

**SonarQube** is a code quality analysis tool that checks:

* Code smells
* Bugs
* Security vulnerabilities
* Test coverage
* Duplication

It integrates into CI/CD pipelines to enforce code quality standards.

---

## 2. What is a Quality Gate?

A **Quality Gate** is a set of conditions that your project must meet before it is considered “good quality”.

Think of it as a **pass/fail checkpoint** for your code.

### Common Quality Gate Conditions

* Coverage ≥ 80%
* Bugs = 0
* Vulnerabilities = 0
* Code Smells < threshold
* Duplications < 3%

If conditions fail → Build fails (in CI/CD)

---

## 3. Why Quality Gates are Important

* Enforces **minimum quality standards**
* Prevents **bad code from being merged**
* Encourages **test writing**
* Improves **maintainability**

---

## 4. JaCoCo – Code Coverage Tool

**JaCoCo (Java Code Coverage)** measures:

* % of code executed by tests
* Line coverage
* Branch coverage

SonarQube uses JaCoCo reports to evaluate coverage.

---

## 5. Integrating JaCoCo with Spring Boot

### Step 1: Add JaCoCo Plugin (Maven)

```xml
<build>
  <plugins>
    
    <!-- JaCoCo Plugin -->
    <plugin>
      <groupId>org.jacoco</groupId>
      <artifactId>jacoco-maven-plugin</artifactId>
      <version>0.8.10</version>
      
      <executions>
        <!-- Attach JaCoCo agent -->
        <execution>
          <goals>
            <goal>prepare-agent</goal>
          </goals>
        </execution>

        <!-- Generate report -->
        <execution>
          <id>report</id>
          <phase>test</phase>
          <goals>
            <goal>report</goal>
          </goals>
        </execution>
      </executions>
    </plugin>

  </plugins>
</build>
```

---

###  Step 2: Run Tests

```bash
mvn clean test
```

👉 This generates coverage report at:

```
target/site/jacoco/index.html
```

---

###  Step 3: Configure SonarQube

Add to `application.properties` or `sonar-project.properties`:

```properties
sonar.projectKey=my-springboot-app
sonar.host.url=http://localhost:9000
sonar.login=YOUR_TOKEN

# JaCoCo Report Path
sonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml
```
*** Alternatively you can add  the following sonar plugin and propertie in pom.xml***
```xml
<properties>
    <sonar.projectKey>your_project_key</sonar.projectKey>
    <sonar.host.url>http://your_sonarqube_server_url</sonar.host.url>
    <!-- Use sonar.token for authentication, pass via command line for security -->
    <!-- <sonar.token>YOUR_SONAR_TOKEN</sonar.token> --> 
    <sonar.coverage.jacoco.xmlReportPaths>
    target/site/jacoco-aggregate/jacoco.xml
  </sonar.coverage.jacoco.xmlReportPaths>
</properties>

<build>
    <pluginManagement>
        <plugins>
            <plugin>
                <groupId>org.sonarsource.scanner.maven</groupId>
                <artifactId>sonar-maven-plugin</artifactId>
                <version>3.4.0.905</version>
            </plugin>
        </plugins>
    </pluginManagement>
</build>

```
---

###  Step 4: Generate XML Report (Important)

Add this to JaCoCo plugin:

```xml
<execution>
  <id>report</id>
  <phase>test</phase>
  <goals>
    <goal>report</goal>
  </goals>
  <configuration>
    <formats>
      <format>XML</format>
      <format>HTML</format>
    </formats>
  </configuration>
</execution>
```

👉 SonarQube needs **XML**, not just HTML.

---

### Step 5: Run Sonar Analysis

```bash
mvn verify sonar:sonar

```
### OR (if you have not defined the properties in pom.xml)
```bash
mvn clean verify sonar:sonar -Dsonar.projectKey=PROJECT_KEY 
                             -Dsonar.projectName='PROJECT_NAME' 
                             -Dsonar.host.url=http://localhost:9000 
                             -Dsonar.token=THE_GENERATED_TOKEN
```
---

## 6. How SonarQube Uses JaCoCo

Flow:

```
Unit Tests → JaCoCo → Coverage Report → SonarQube → Quality Gate Evaluation
```

---

## 7. Example Quality Gate (Recommended for Beginners)

| Metric          | Condition |
| --------------- | --------- |
| Coverage        | ≥ 80%     |
| Bugs            | = 0       |
| Vulnerabilities | = 0       |
| Code Smells     | < 10      |

---

## 8. Enforcing Quality Gates in CI/CD

### Example (Jenkins / GitHub Actions)

```bash
mvn clean verify sonar:sonar
```

👉 If Quality Gate fails:

* Pipeline fails
* Code is rejected

---

## 9. Best Practices

###  Coverage

* Focus on **critical business logic**
* Avoid chasing 100% blindly

###  Tests

* Use:

  * `@SpringBootTest`
  * `@WebMvcTest`
  * `@DataJpaTest`

### Exclusions (Optional)

```properties
sonar.exclusions=**/config/**,**/dto/**
```

---

## 10. Common Mistakes

Not generating XML report
Wrong report path
Running sonar before tests
Ignoring failed quality gate
Writing tests only for coverage (not logic)

---

## 11. Summary

* **JaCoCo** → generates coverage data
* **SonarQube** → analyzes quality + coverage
* **Quality Gate** → enforces standards

👉 Together they ensure:

* Reliable code
* Maintainable systems
* Strong testing discipline

---
