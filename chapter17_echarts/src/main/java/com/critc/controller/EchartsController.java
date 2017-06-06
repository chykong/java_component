package com.critc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * Author  孔垂云
 * Date  2017/6/5.
 */
@Controller
@RequestMapping("/echarts")
public class EchartsController {

    @RequestMapping("/bar")
    public ModelAndView bar() {
        ModelAndView mv = new ModelAndView();
//        List<Staff> list = staffService.list();
//        mv.addObject("list", list);
        mv.setViewName("echarts");
        return mv;
    }

    @RequestMapping("/loaddata")
    public ModelAndView loaddata() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("loaddata");
        return mv;
    }

    /**
     * 取json数据
     *
     * @return
     */
    @RequestMapping("/getData")
    public void getData(HttpServletResponse response) throws Exception {
        String json = "{\"categories\": [\"衬衫\",\"羊毛衫\",\"雪纺衫\",\"裤子\",\"高跟鞋\",\"袜子\"], \"data\": [5, 20, 36, 10, 10, 20]}";
        response.setContentType("text/html; charset=UTF-8");
        System.out.println(json);
        response.getWriter().println(json);
    }
}
