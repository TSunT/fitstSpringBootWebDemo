package cn.edu.nuaa.firstspringbootwebproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/loginUser")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            Model model,
                            HttpSession session){
        if (!StringUtils.isEmpty(username) && "1234".equals(password)){
            session.setAttribute("loginuser",username);
            return "redirect:/main";
        }else {
            model.addAttribute("msg","用户密码错误");
            return "index";
        }
    }
}
