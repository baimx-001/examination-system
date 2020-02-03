package com.study.exam.controller;

import com.alibaba.fastjson.JSONObject;
import com.study.exam.entity.Subject;
import com.study.exam.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
    public ModelAndView showSubject() {
        return new ModelAndView("showSubject");
    }
//    @RequestMapping(value = "/getSubjectByIdAndType",produces = "text/html;charset=utf-8")

    @ResponseBody
    @RequestMapping(value = "/getSubjectByIdAndType",produces = "text/html;charset=utf-8")
    public String getSubjectByIdAndType(Integer id, String type, String option, HttpSession session) {
        int userId = (int)session.getAttribute("userId");
        Subject subject = subjectService.getSubjectByIdAndType(id, type,option,userId);
        String content = JSONObject.toJSONString(subject);
        return content;
    }
    @RequestMapping("/submitSubjects")
    public ModelAndView submitSubjects(Integer id,String option,HttpSession session){
        int userId = (int)session.getAttribute("userId");
        int score=subjectService.submitSubjects(id,option,userId);
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("score",score);
        return new ModelAndView("score",map);
    }
    @RequestMapping("/findScore")
    public ModelAndView findScore(HttpSession session){
        int userId = (int)session.getAttribute("userId");
        int score=subjectService.findScore(userId);
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("score",score);
        return new ModelAndView("findScore",map);
    }
}
