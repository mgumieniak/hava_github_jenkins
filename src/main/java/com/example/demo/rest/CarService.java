package com.example.demo.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarService {

    private final Repo repo;

    public CarService(Repo repo) {
        this.repo = repo;
    }

    @Cacheable(cacheNames = "getCarId")
    public String getCarId(String carId) {
        log.info("CarService; getCarId with id: {}", carId);
        return repo.getCarId(carId);
    }
}
