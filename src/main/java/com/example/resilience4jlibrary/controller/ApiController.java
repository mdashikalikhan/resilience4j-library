package com.example.resilience4jlibrary.controller;

import com.example.resilience4jlibrary.service.ExternalService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiController {
    private final ExternalService externalService;

    @GetMapping("/data")
    @CircuitBreaker(name = "externalService", fallbackMethod = "fallbackData")
    /*@RateLimiter(name = "externalService", fallbackMethod = "fallbackRateLimiter")
    @Bulkhead(name = "externalService", type = Bulkhead.Type.THREADPOOL,
                fallbackMethod = "fallbackBulkhead")*/
    public String getData(){
        return externalService.fetchData();
    }

    public String fallbackData(Exception ex){
        return "fallback Circuit Breaker: " + ex.getMessage();
    }

    public String fallbackRateLimiter(Throwable ex){
        return "fallback Rate Limiter: " + ex.getMessage();
    }

    public String fallbackBulkhead(Throwable ex){
        return "fallback Bulkhead: " + ex.getMessage();
    }

}
