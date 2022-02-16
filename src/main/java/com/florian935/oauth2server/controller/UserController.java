package com.florian935.oauth2server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1.0/users")
public class UserController {

    @GetMapping
    String hello() {

        return "Hello world !";
    }

    @GetMapping(path ="/{name}")
    String helloUser(@PathVariable String name) {

        return String.format("Hello %s", name);
    }

    @GetMapping(path = "/admin/{name}")
    String helloAdmin(@PathVariable String name) {

        return String.format("Hello admin %s", name);
    }


}
