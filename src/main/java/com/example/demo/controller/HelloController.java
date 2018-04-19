package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by attila.kormos on 2018. 04. 19..
 */

@RestController
@RequestMapping(value = "/")
public class HelloController {

    @GetMapping("/index")
    public String index () {
        return "Welcome to the home page!";
    }

}
