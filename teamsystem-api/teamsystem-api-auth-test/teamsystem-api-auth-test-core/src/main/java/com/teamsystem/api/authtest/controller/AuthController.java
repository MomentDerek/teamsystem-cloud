package com.teamsystem.api.authtest.controller;

import com.teamsystem.api.authtest.input.AuthInput;
import com.teamsystem.common.web.response.R;
import com.teamsystem.common.web.response.RUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/authtest")
public class AuthController {

    @GetMapping("/echo")
    public R echo(@Validated AuthInput authInfo) {
        return RUtils.create("echo from auth controller, message: " + authInfo.getUserName() + ":" + authInfo.getPassword());
    }

    @PostMapping("/echo")
    public R echoPost(@Validated @RequestBody AuthInput authInfo) {
        return RUtils.create("echo from auth controller, message: " + authInfo.getUserName() + ":" + authInfo.getPassword());
    }

}
