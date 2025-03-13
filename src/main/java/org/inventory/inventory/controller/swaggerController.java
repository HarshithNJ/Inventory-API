package org.inventory.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class swaggerController {
    
    @GetMapping("/")
    public String home() {
        return "redirect:/swagger-ui/index.html";
    }
}
