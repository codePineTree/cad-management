package com.cad.cadmanagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @GetMapping("/test")
    public String hello() {
        return "Spring + Oracle + MyBatis 연동 확인";
    }
}
