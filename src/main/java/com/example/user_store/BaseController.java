package com.example.user_store;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping("/public")
    public String getPublic() {
        return "/public is accessed";
    }
    @GetMapping("/private")
    public String getPrivate() {
        return "/private is accessed";
    }
}
