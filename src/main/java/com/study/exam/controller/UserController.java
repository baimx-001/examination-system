package com.study.exam.controller;

import com.study.exam.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/addUser")
    public ModelAndView addUser() {
        return new ModelAndView("addUser");
    }

    @RequestMapping("/submitUser")
    public ModelAndView submitUser(String username, String password) {
        String reslut = userService.addUser(username, password);
        Map<String, String> map = new HashMap<String, String>();
        map.put("message", reslut);
        return new ModelAndView("addUser", map);
    }
}
