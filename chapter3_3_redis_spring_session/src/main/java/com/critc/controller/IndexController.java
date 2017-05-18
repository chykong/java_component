package com.critc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 孔垂云 on 2017/5/18.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = "login")
    public String login(HttpServletRequest request, String username) {
        return "login";
    }

    @RequestMapping(value = "checkLogin")
    public String checkLogin(HttpServletRequest request, String username) {
        request.getSession().setAttribute("user", "admin");
        return "redirect:/index.htm";
    }

    @RequestMapping(value = "index")
    public String index(HttpServletRequest request, Model model) {
        System.out.println(request.getSession().getAttribute("user"));
        return "index";
    }
}
