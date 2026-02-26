package com.demo.spring.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class GreetController {
    @GetMapping(path="/greet/{name}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String greet(@PathVariable("name") String userName){

        return "Hello "+userName;
    }
}
