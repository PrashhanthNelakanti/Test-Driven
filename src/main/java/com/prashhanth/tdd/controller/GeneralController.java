package com.prashhanth.tdd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController {

    @GetMapping("/status")
    public String getServerStatus(){
        return "Is Connected..";
    }
}
