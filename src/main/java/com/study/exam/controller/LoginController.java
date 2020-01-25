package com.study.exam.controller;

import com.study.exam.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Resource
    private UserService userService;
    @RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }
    @RequestMapping("checkLogin")
    public ModelAndView checkLogin(String username,String password){
        boolean flag=userService.checkLogin(username,password);
        if(flag){
            return new ModelAndView("addSubject");
        }else {
            Map<String,String> map=new HashMap<String,String>();
            map.put("message","用户名或密码错误");
            return new ModelAndView("login",map);
        }
    }

}
