package com.yun.seckilldemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wanglufei
 * @title: HelloController
 * @projectName seckill-demo
 * @description: TODO
 * @date 2021/10/30/7:43 下午
 */
@Controller
@RequestMapping("/demo")
public class HelloController {
    /**
     * @param model
     * @desc 测试页面跳转
     * @Return: java.lang.String
     * @author: wanglufei
     * @date: 2021/10/30 7:51 下午
     * @Version V1.1.0
     */
    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "xxx");
        return "hello";
    }
}
