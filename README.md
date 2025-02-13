
# Spring Boot Resilient Microservice with Resilience4j

## Overview

This project demonstrates how to build a resilient and fault-tolerant microservice using **Spring Boot 3** and **Resilience4j**. It integrates key resilience patterns like **Circuit Breaker**, **Rate Limiter**, and **Bulkhead** to protect the service from failures and high load, ensuring high availability and stability.

---

## Features

- ✅ **Circuit Breaker:** Prevents repeated service calls when the downstream service is failing, allowing the system to recover gracefully.
- ✅ **Rate Limiter:** Controls the rate of incoming requests to avoid overwhelming the service during high traffic spikes.
- ✅ **Bulkhead:** Isolates resources by limiting concurrent calls, preventing cascading failures.
- ✅ **Fallback Mechanisms:** Provides meaningful fallback responses when failures occur.
- ✅ **Actuator Monitoring:** Enables real-time monitoring of service health and resilience metrics.

---

## Tech Stack

- **Java 17**  
- **Spring Boot 3.1.0**  
- **Resilience4j**  
- **Spring Boot Actuator**  
- **Maven**  

---

## Project Structure

```
circuit-breaker-demo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.circuitbreaker/
│   │   │       ├── CircuitBreakerDemoApplication.java
│   │   │       ├── controller/
│   │   │       │   └── ApiController.java
│   │   │       └── service/
│   │   │           └── ExternalService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application.yml
├── pom.xml
└── README.md
```

---

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/mdashikalikhan/resilience4j-library.git
cd resilience4j-library
```

### 2. Build the Project

```bash
mvn clean install
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

### 4. Access the API

- **Successful Response:**  
  `http://localhost:8080/api/data`

- **Actuator Endpoints:**  
  - `/actuator/health`  
  - `/actuator/metrics/resilience4j.circuitbreaker.calls`  
  - `/actuator/metrics/resilience4j.ratelimiter.calls`

---

## Resilience4j Configuration

```yaml
resilience4j:
  circuitbreaker:
    instances:
      externalService:
        slidingWindowSize: 5
        failureRateThreshold: 50
        waitDurationInOpenState: 10s

  ratelimiter:
    instances:
      externalService:
        limitForPeriod: 50
        limitRefreshPeriod: 1s

  bulkhead:
    instances:
      externalService:
        maxConcurrentCalls: 10
```

---

## Future Enhancements

- 🔄 **Docker & Kubernetes Deployment**  
- 📈 **Distributed Tracing with Zipkin/Jaeger**  
- 🔐 **OAuth2/JWT Security Integration**  
- 🌐 **API Gateway Integration**

---

## Contributing

1. Fork the repository.  
2. Create a feature branch (`git checkout -b feature-name`).  
3. Commit your changes (`git commit -m 'Add feature'`).  
4. Push to the branch (`git push origin feature-name`).  
5. Open a **Pull Request**.

---

## License

This project is licensed under the **MIT License**.
