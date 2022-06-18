package com.prashhanth.tdd.controller;


import com.prashhanth.tdd.entity.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getCarDetails() throws Exception{
        ResponseEntity<com.prashhanth.tdd.entity.Car> audi = testRestTemplate.getForEntity("/cars/audi", Car.class);
        assertThat(audi.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(audi.getBody().getCar()).isEqualTo("Audi");
        assertThat(audi.getBody().getModel()).isEqualTo("A8");
    }
}