package com.study.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExamController {

    /**
     * 测试mvc
     * @return
     */
    @RequestMapping("/testController")
    @ResponseBody
   public String testController(){
       return "baimx";
   }
    @RequestMapping("/testHtml")
    public ModelAndView testHtml(){
        return new ModelAndView("test1");//WEB-INF/test.html
    }
}
