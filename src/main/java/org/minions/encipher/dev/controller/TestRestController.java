package org.minions.encipher.dev.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="test")
public class TestRestController {

    @RequestMapping(value = "hello")
    public String hello(@RequestParam(defaultValue = "world!") String userName) {
        return "hello, " + userName;
    }
}
