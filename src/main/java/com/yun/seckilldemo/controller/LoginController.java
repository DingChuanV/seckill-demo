package com.yun.seckilldemo.controller;

import com.yun.seckilldemo.service.IUserService;
import com.yun.seckilldemo.vo.Loginvo;
import com.yun.seckilldemo.vo.RespBean;
import com.yun.seckilldemo.vo.RespBeanEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author wanglufei
 * @title: LoginController
 * @projectName seckill-demo
 * @description: TODO
 * @date 2021/10/31/2:18 下午
 */
@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private IUserService userService;
    /**
     * @param
     * @desc 跳转到登陆页面
     * @Return: java.lang.String
     * @author: wanglufei
     * @date: 2021/10/31 2:20 下午
     * @Version V1.1.0
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * @param loginvo
     * @desc 登陆功能
     * @Return: com.yun.seckilldemo.vo.RespBean
     * @author: wanglufei
     * @date: 2021/10/31 2:56 下午
     * @Version V1.1.0
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(@Valid Loginvo loginvo, HttpServletRequest request,
                            HttpServletResponse response) {
//        log.info("{}l", loginvo);
        return userService.doLogin(loginvo,request,response);
    }
}
