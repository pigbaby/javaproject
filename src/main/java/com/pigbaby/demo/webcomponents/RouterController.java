package com.pigbaby.demo.webcomponents; 

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping; 

/**
 * RouterController
 */
@Controller
public class RouterController {
    @RequestMapping("/index")
    public String index() {
        return "test"; 
    }
}