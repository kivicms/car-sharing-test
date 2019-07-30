package com.kivicms.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String main() {
        return "home/index";
    }
}