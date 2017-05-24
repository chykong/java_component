package com.critc.verify.controller;

import com.critc.verify.util.RandomCodeUtil;
import com.critc.verify.util.VerifyCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author  孔垂云
 * Date  2017/5/24.
 */
@Controller
public class VerifyController {
    /**
     * 进入界面
     *
     * @return
     */
    @RequestMapping("/verify")
    public ModelAndView verify() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("verify");
        return mv;
    }

    /**
     * 生成图形验证码
     *
     * @param request
     * @param response
     * @param username
     * @throws Exception
     */
    @RequestMapping(value = "/generateVerifyCode")
    public void generateVerifyCode(HttpServletRequest request, HttpServletResponse response, String username) throws Exception {
        String randomCode = RandomCodeUtil.createRandomNum(4);//生成四位随机数
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        VerifyCodeUtil vCode = new VerifyCodeUtil(120, 40, 4, 100, randomCode);
        request.getSession().setAttribute("verifyCode", randomCode);//放入到session中
        vCode.write(response.getOutputStream());
    }
}
