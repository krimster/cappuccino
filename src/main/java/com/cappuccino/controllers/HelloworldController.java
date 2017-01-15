package com.cappuccino.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by krime on 1/15/17.
 */
@Controller
public class HelloworldController {

    @RequestMapping("/")
    public String sayHello() {
        return "index";
    }
}
