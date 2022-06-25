package com.prashhanth.ims.inventory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    @GetMapping("/")
    public String msg(){
        return "Inventory ready";
    }
}
