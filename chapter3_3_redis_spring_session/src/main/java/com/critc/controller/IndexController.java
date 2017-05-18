package com.critc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 孔垂云 on 2017/5/18.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    /**
     * 模拟进度登录界面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "login")
    public String login(HttpServletRequest request) {
        return "login";
    }

    /**
     * 模拟登录
     * @param request
     * @return
     */
    @RequestMapping(value = "checkLogin")
    public String checkLogin(HttpServletRequest request) {
        request.getSession().setAttribute("user", "admin");
        return "redirect:/index.htm";
    }

    /**
     * 模拟进入首页
     * @param request
     * @return
     */
    @RequestMapping(value = "index")
    public String index(HttpServletRequest request) {
        System.out.println(request.getSession().getAttribute("user"));
        return "index";
    }
}
