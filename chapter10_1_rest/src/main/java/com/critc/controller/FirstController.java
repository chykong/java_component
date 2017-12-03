package com.critc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 孔垂云 on 2017/11/30.
 */
@RestController
@RequestMapping("/")
public class FirstController {

    @RequestMapping("/sayHello")
    public String sayHelllo(HttpServletRequest request, @RequestParam("name") String name) {
        return request.getLocalPort() + "hello:" + name;
    }
}
