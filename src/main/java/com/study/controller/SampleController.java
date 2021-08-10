package com.study.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j
public class SampleController {
    @GetMapping("/index")
    public String index() {
        log.info("index");
        return "index";
    }
}
