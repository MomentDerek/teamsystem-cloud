package com.teamsystem.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author Moment
 */
@RestController
@RequestMapping("/security/test")
public class SecurityTestController {

    @GetMapping("/echo")
    public String echo() {
        return "helloWorld";
    }

}
