package ru.ivanmarkov.backend_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    String index(){
        return "hello world";
    }
}
