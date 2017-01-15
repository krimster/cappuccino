package com.cappuccino.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by krime on 1/15/17.
 */
@Controller
public class CopyController {

    @RequestMapping("/about")
    public String about(){
        return "copy/about";
    }

}
