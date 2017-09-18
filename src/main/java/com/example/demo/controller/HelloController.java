package com.example.demo.controller;

import com.example.demo.properties.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xzf on 2017/9/13.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private StudentProperties studentProperties;

    @GetMapping("/say")
    public String say() {
        return studentProperties.getAddress();
    }

}
