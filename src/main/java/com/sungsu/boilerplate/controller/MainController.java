package com.sungsu.boilerplate.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping(value = "/main", produces = MediaType.TEXT_HTML_VALUE)
    public String main() {
        return "test";
    }
}
