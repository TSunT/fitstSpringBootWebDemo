package cn.edu.nuaa.firstspringbootwebproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping("/test")
    public String hello(Model model){
        model.addAttribute("msg","hello,world");
        return "test";
    }
}
