package com.example.demo.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class Repo {
    public String getCarId(String carId) {
        log.info("Repo; getCarId with id: {}", carId);
        String genValue = UUID.randomUUID().toString();
        log.info("Repo; generate value: {}", genValue);
        return genValue;
    }
}
