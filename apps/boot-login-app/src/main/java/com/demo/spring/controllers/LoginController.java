package com.demo.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    //http://localhost:8081/greet/Shantanu
    @GetMapping(path="/greet/{name}")
    public ModelAndView greet(@PathVariable("name") String userName ){
        System.out.println("Inside Greet Method....");
        ModelAndView mv= new ModelAndView();
        mv.setViewName("login");
        mv.addObject("message",userName+", Welcome to Spring MVC");
        return mv;
    }
}
