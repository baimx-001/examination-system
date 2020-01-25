package com.study.exam.controller;

import com.study.exam.entity.Subject;
import com.study.exam.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    @Resource
    SubjectService subjectService;

    @RequestMapping("/addSubject")
    public ModelAndView addSubject() {
        return new ModelAndView("addSubject");
    }

    @RequestMapping("/submitSubject")
    public ModelAndView submitSubject(String title, String optionA,
                                      String optionB, String optionC,
                                      String optionD, String rightOption,
                                      double score) {
        String result = subjectService.submitSubject(title, optionA, optionB, optionC,
                optionD, rightOption, score);
//        Map<String,String> map=new HashMap<String,String>();
//        map.put("message",result);
        //转换成JSON
        return new ModelAndView("addSubject");
    }

    @RequestMapping("/showSubject")
    public ModelAndView showSubject(){
        return new ModelAndView("showSubject");
    }
    @RequestMapping("/getSubjectByIdAndType")
    public Subject getSubjectByIdAndType(String id,String type){
        return subjectService.getSubjectByIdAndType(id,type);
    }
}
