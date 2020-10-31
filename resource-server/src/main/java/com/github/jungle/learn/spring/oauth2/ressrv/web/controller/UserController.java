package com.github.jungle.learn.spring.oauth2.ressrv.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: UserController
 *
 * @author jungle
 * @version 1.0
 * @date 2020/10/30
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @RequestMapping("/me")
    public Object me() {
        return "hello from jungle";
    }

}
