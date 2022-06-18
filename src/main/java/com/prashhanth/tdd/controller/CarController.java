package com.prashhanth.tdd.controller;

import com.prashhanth.tdd.entity.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @GetMapping("/cars/audi")
    public Car getCars(){
        Car audi = new Car();
        audi.setCar("Audi");
        audi.setModel("A8");
       return audi;
    }
}
