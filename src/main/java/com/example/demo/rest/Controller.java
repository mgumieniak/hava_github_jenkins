package com.example.demo.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class Controller {

    private final CarService carService;

    public Controller(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/{carId}")
    public String getCarId(@PathVariable String carId){
        log.info("Controller; getCarId with id: {}",carId);
        return carService.getCarId(carId);
    }
}
