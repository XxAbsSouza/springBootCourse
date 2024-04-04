package com.udemy.helloSpring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //expose "/" that return "Hello World"
    @GetMapping("/")
    public  String SayHello(){
        return "Hello World";
    }
}
