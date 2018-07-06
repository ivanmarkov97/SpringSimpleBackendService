package ru.ivanmarkov.backend_service.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ivanmarkov.backend_service.entity.Role;
import ru.ivanmarkov.backend_service.entity.User;

import static java.util.stream.Collectors.joining;

@RestController
public class IndexController {

    @GetMapping("/")
    String index() {
        return "hello";
    }
}
