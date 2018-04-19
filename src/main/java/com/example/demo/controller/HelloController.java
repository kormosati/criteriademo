package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by attila.kormos on 2018. 04. 19..
 */

@Controller
@RequestMapping(value = "/")
public class HelloController {

    @GetMapping("/hello")
    public String hello () {
        return "hello";
    }

    @GetMapping("/home")
    public String home () {
        return "home";
    }

    @GetMapping("/login")
    public String login () {
        return "login";
    }

    @GetMapping("/logout")
    public String logout () {
        return "logout";
    }
}
