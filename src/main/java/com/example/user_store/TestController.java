package com.example.user_store;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String root() {
        return "/ is accessed";
    }
    @GetMapping("/test")
    public String test() {
        return "/test is accessed";
    }
}
