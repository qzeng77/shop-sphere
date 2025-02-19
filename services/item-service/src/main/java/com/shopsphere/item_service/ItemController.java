package com.shopsphere.item_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @GetMapping("/test")
    public String test() {
        return "Account service is working!";
    }
}
