package com.example.resilience4jlibrary.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ExternalService {
    private final Random random = new Random();

    public String fetchData(){
        if(random.nextInt(20)<10){
            throw new RuntimeException("Service Failed");
        }
        return "Data from external service";
    }
}
