/*
package com.prashhanth.tdd.controller;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxMonoExpTest {

    FluxMonoExp fluxMonoExp = new FluxMonoExp();

    @Test
    void getFruits() {
        var fruit=fluxMonoExp.getFruits();
        StepVerifier.create(fruit).expectNext("Apple","Mango","Lemon").verifyComplete();
    }

    @Test
    void getVeggies() {
      var veggies = fluxMonoExp.getVeggies();
      StepVerifier.create(veggies).expectNext("Potato").verifyComplete();
    }

    @Test
    void getFruitsMap() {
        var fruitsMap = fluxMonoExp.getFruitsMap();
        StepVerifier.create(fruitsMap).expectNext("APPLE","MANGO","LEMON");
    }

    @Test
    void getFruitsFilterMap() {
        var fruitsFilterMap= fluxMonoExp.getFruitsFilterMap(5);
        StepVerifier.create(fruitsFilterMap).expectNext("jack fruit","papaya","grapes").verifyComplete();
    }

    @Test
    void getFruitsMFlatmap() {
        var fruitsFilterMap= fluxMonoExp.getFruitsMFlatmap();
        StepVerifier.create(fruitsFilterMap).expectNextCount(15).verifyComplete();

    }
}
*/
