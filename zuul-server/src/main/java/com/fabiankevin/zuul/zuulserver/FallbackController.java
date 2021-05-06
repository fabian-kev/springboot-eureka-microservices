package com.fabiankevin.zuul.zuulserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {



    @GetMapping("default-fallback")
    public String defaultFallBack(){
        return "Sorry, This service is unavailable right now. Please try again later.";
    }


}
